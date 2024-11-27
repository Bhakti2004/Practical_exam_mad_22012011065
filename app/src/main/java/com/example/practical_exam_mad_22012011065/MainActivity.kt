package com.example.practical_exam_mad_22012011065

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventEaseApp()
        }
    }
}

@Composable
fun EventEaseApp() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            EventDetailsScreen()
        }
    }
}

@Composable
fun EventDetailsScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()

            .padding(16.dp)
    ) {
        // Event Image
        Image(
            painter = painterResource(id = R.drawable.event), // Replace with your image resource
            contentDescription = "Event Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Event Title
        Text(
            text = "Tech Conference 2024",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        // Event Location and Description
        Text(
            text = "Mehsana, Gujarat | 2.5 km away",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = "This is a detailed description of the event...",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Event Schedule (Now horizontally scrollable)
        Text(
            text = "Event Schedule",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Horizontal scrolling row for schedule items
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            // Add multiple schedule cards here with large text for all schedule items
            ScheduleCard(ScheduleItemData("10:00 AM", "Keynote Speech", true))
            ScheduleCard(ScheduleItemData("11:30 AM", "Networking Session", false))
            ScheduleCard(ScheduleItemData("1:00 PM", "Lunch Break", false))
            ScheduleCard(ScheduleItemData("2:30 PM", "Panel Discussion", false))
            ScheduleCard(ScheduleItemData("4:00 PM", "Closing Remarks", false))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Reviews Section
        Text(
            text = "Reviews",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        ReviewItem(name = "Alice Johnson", review = "Great event! Well-organized and informative.", rating = 5)
        ReviewItem(name = "Bob Smith", review = "Really enjoyed the keynote speaker. Would recommend!", rating = 4)
        ReviewItem(name = "Charlie Davis", review = "Good overall, but some sessions were too short.", rating = 3)

        Spacer(modifier = Modifier.height(16.dp))

        // Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /* Handle Buy Tickets */ }) {
                Text("Buy Tickets")
            }
            Button(onClick = { /* Handle Add to Calendar */ }) {
                Text("Add to Calendar")
            }
        }
    }
}

@Composable
fun ScheduleCard(item: ScheduleItemData) {
    Card(
        modifier = Modifier
            .width(220.dp)  // Adjust width as per your design
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = item.time,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold, fontSize = 18.sp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item.description,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold, fontSize = 22.sp) // Large font for all schedule items
            )
        }
    }
}

data class ScheduleItemData(val time: String, val description: String, val isKeynote: Boolean)

@Composable
fun ReviewItem(name: String, review: String, rating: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = "$name (${rating}★)",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = review,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EventDetailsPreview() {
    EventEaseApp()
}
