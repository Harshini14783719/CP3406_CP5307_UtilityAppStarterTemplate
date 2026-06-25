package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.ui.theme.CP3406_CP5603UtilityAppStarterTemplateTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.viewmodel.FocusViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP3406_CP5603UtilityAppStarterTemplateTheme {
                UtilityApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UtilityAppPreview() {
    CP3406_CP5603UtilityAppStarterTemplateTheme {
        UtilityApp()
    }
}

@Composable
fun UtilityApp() {
    var selectedTab by remember { mutableStateOf("Utility") }
    val focusViewModel: FocusViewModel = viewModel()

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Utility") },
                    label = { Text("Utility") },
                    selected = selectedTab == "Utility",
                    onClick = { selectedTab = "Utility" }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
                    label = { Text("Settings") },
                    selected = selectedTab == "Settings",
                    onClick = { selectedTab = "Settings" }
                )
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedTab) {
                "Utility" -> UtilityScreen(focusViewModel)
                "Settings" -> SettingsScreen(focusViewModel)
            }
        }
    }
}

@Composable
fun UtilityScreen(viewModel: FocusViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {

        Text(
            text = "FocusFlow",
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = "🌤 Weather: ${viewModel.weather.value}",
            style = MaterialTheme.typography.bodyLarge
        )
        
        Text(
            text = "💬 Quote: ${viewModel.quote.value}",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "🧠 Focus Score: ${viewModel.focusScore.value}/100",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "⏳ Study Timer: ${viewModel.timer.value}:00",
            style = MaterialTheme.typography.bodyLarge
        )

        Button(onClick = { viewModel.startTimer() }) {
            Text("Start")
        }

        Button(onClick = { viewModel.resetTimer() }) {
            Text("Reset")
        }

        Text(
            text = "📈 Status: Excellent Focus Day",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun SettingsScreen(viewModel: FocusViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Text(
            text = "Settings",
            style = MaterialTheme.typography.headlineMedium
        )

        Text("Study Session Length")

        Button(onClick = { viewModel.setTimer(25) }) {
            Text("25 Minutes")
        }

        Button(onClick = { viewModel.setTimer(45) }) {
            Text("45 Minutes")
        }

        Button(onClick = { viewModel.setTimer(60) }) {
            Text("60 Minutes")
        }

        Text("Theme Options")

        Button(onClick = { viewModel.toggleDarkMode() }) {
            Text("Dark Mode")
        }

        Button(onClick = { }) {
            Text("Enable Animations")
        }

        Button(onClick = { }) {
            Text("Show Quotes")
        }
    }
}