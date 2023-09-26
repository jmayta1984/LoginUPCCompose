package pe.edu.logincompose.ui.characterlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import pe.edu.logincompose.data.model.Character

@Composable
fun CharacterList(viewModel: CharacterListViewModel) {
    val characters: List<Character> by viewModel.characters.observeAsState(listOf())
    viewModel.getAll()
    LazyColumn {
        items(characters) { character ->
            CharacterCard(character,
                delete = {
                    viewModel.delete(character)
                },
                insert = {
                    viewModel.save(character)
                }
            )
        }
    }
}

@Composable
fun CharacterCard(character: Character, delete: () -> Unit, insert: () -> Unit) {
    val isFavorite = remember { mutableStateOf(false) }
    isFavorite.value = character.isFavorite
    Card(modifier = Modifier.padding(8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(8.dp)
        ) {
            GlideImage(
                imageModel = { character.image }, // loading a network image using an URL.
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.Center
                ),
                modifier = Modifier
                    .width(92.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.weight(5f)) {
                Text(text = character.name)
                Text(text = character.species)
                Row(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = character.status,
                        modifier = Modifier
                            .background(Color.Green)
                            .padding(2.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = character.gender,
                        modifier = Modifier
                            .background(Color.Cyan)
                            .padding(2.dp)
                    )
                }
            }
            IconButton(onClick = {
                if (isFavorite.value) {
                    delete()
                } else {
                    insert()
                }
                isFavorite.value = !isFavorite.value
            }, modifier = Modifier.weight(1f)) {
                Icon(
                    Icons.Filled.Star,
                    null,
                    tint = if (isFavorite.value) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.inverseOnSurface
                )
            }
        }
    }
}