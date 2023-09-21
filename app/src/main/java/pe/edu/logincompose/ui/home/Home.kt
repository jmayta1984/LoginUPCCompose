package pe.edu.logincompose.ui.home

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.logincompose.ui.characterlist.CharacterList
import pe.edu.logincompose.ui.characterlist.CharacterListViewModel

@Composable
fun Home() {
    val navController = rememberNavController()
    val viewModel: CharacterListViewModel = viewModel()

    NavHost(navController = navController, startDestination = "CharacterList") {

        composable("CharacterList") {

            CharacterList(viewModel)
        }
    }
}