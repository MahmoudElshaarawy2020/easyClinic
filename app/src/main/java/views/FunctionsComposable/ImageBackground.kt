package views.FunctionsComposable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
@Composable
fun ImageBackground(painter: Painter){
    Image(
        painter = painter,
        contentDescription = null, // Provide a meaningful description if needed
        modifier = Modifier
            .fillMaxSize(1f)
            .alpha(0.3f)
            , contentScale = ContentScale.FillBounds
    )

}