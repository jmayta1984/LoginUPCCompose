package pe.edu.logincompose.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import pe.edu.logincompose.ui.characterlist.CharacterList
import pe.edu.logincompose.ui.characterlist.CharacterListViewModel
import pe.edu.logincompose.ui.favorites.Favorites

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    val navController = rememberNavController()

    val bottomNavigationItems = listOf(
        BottomNavigationScreen.CharacterList,
        BottomNavigationScreen.Favorites,
    )

    Scaffold(
        bottomBar = {
            AppBottomNavigation(navController, bottomNavigationItems)
        }
    ) { paddingValues ->
        Main(navController, modifier = Modifier.padding(paddingValues))
    }
}

@Composable
fun AppBottomNavigation(navController: NavHostController, items: List<BottomNavigationScreen>) {
    BottomNavigation {
        val navaBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navaBackStackEntry?.destination
        items.forEach { screen ->
            BottomNavigationItem(selected = currentDestination?.hierarchy?.any {
                it.route == screen.route
            } == true, onClick = {
                navController.navigate(screen.route)
            }, icon = {
                Icon(screen.icon, null)
            })
        }
    }
}

@Composable
fun Main(navController: NavHostController, modifier: Modifier) {
    val viewModel: CharacterListViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = BottomNavigationScreen.CharacterList.route,
        modifier
    ) {

        composable(BottomNavigationScreen.CharacterList.route) {
            CharacterList(viewModel)
        }

        composable(BottomNavigationScreen.Favorites.route) {
            Favorites()
        }
    }
}

sealed class BottomNavigationScreen(val route: String, val icon: ImageVector) {
    object CharacterList : BottomNavigationScreen("CharacterList", Icons.Filled.Home)
    object Favorites : BottomNavigationScreen("Favorites", Icons.Filled.Favorite)
}