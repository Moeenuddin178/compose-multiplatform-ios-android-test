import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class, ExperimentalFoundationApi::class)
@Composable
fun App() {
    MaterialTheme {
        //  val listModel = listOf<ListModel>()


        var List = getTopicsList()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
//            items(listModel) { model ->
//                ListRow(model = model)
//            }

            items(List) { model ->

                ListRow(model = model)

            }
            items(List) { model ->
                ListRow(model = model)
            }
            items(List) { model ->
                ListRow(model = model)
            }
            items(List) { model ->
                ListRow(model = model)
            }
            items(List) { model ->
                ListRow(model = model)
            }
            items(List) { model ->
                ListRow(model = model)
            }

        }

//        var greetingText by remember { mutableStateOf("Hello, World!") }
//        //init custom list
//        var showImage by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = {
//                greetingText = "Hello, ${getPlatformName()}"
//                showImage = !showImage
//            }) {
//                Text(greetingText)
//            }
//            AnimatedVisibility(showImage) {
//                Image(
//                    painterResource(listModel.get(0).image),
//                    null
//                )
//            }
//        }
    }
}


@OptIn(ExperimentalResourceApi::class)
@Composable
fun ListRow(model: ListModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
        //.background("#063041".color)
    ) {
        Card(
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.fillMaxWidth().padding(16.dp).clickable(onClick = {
                //   Toast.makeText(context, " ${message.toString()}${message.name}", Toast.LENGTH_SHORT).show()
            }),
            //  backgroundColor = Color(0xFFFFA867.toInt())
            backgroundColor = Color.White
        ) {
            Row {
                Image(
                    painter = painterResource(model.image),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(5.dp)
                )
                Text(
                    text = model.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
            }

        }


    }
}

fun getTopicsList() = listOf(
    ListModel("Text Examples", "compose-multiplatform.xml"),
    ListModel("What is LiveData?", "compose-multiplatform.xml"),
    ListModel("All about MVVM?", "compose-multiplatform.xml"),
    ListModel("Jetpack DataStore Preferences", "compose-multiplatform.xml"),
    ListModel("Text Styling", "compose-multiplatform.xml"),
)

data class ListModel(
    val name: String,
    val image: String
)

expect fun getPlatformName(): String