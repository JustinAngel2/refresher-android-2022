package com.example.compose_test_3

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.Settings.Global
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.compose_test_3.ui.theme.Compose_test_3Theme
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.time.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContent {
            Compose_test_3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }*/
        setContent { content() }

     //   hilt()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        println("[foo] savedInstanceState $savedInstanceState")
    }

    val viewModel: ViewModelWithHilt by viewModels()
    //@Inject lateinit var viewModel: ViewModelWithHilt


    fun hilt() {
        viewModel.doAThing()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    content()
}

@Composable
fun content() {
   // TextImageButton("foo")
/*    Box(modifier = Modifier.clickable(onClick = { println("onClick") })) {
        Icon(
            painterResource(id = R.drawable.ic_dialog_info),
            contentDescription = ""
        )
    }*/
    //    Greeting("moo")
 //   renderClass(MyClass("foo"))
/*    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally, 
        verticalArrangement = Arrangement.Center) {
        Text(text = stringResource(id = R.string.hello_world),
            color = colorResource(id = R.color.purple_700))
    }*/

    //SimpleFilledTextFieldSample()
   // MyTextField()
//    button()
   /* Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

       // myRadioGroup()
        //fab()
      //  progress()
      //  row()
       // column()

    }*/

   // scaffold()

  //  scroll()

   // lazyColumn()

  //  grid()

//    modifiers()

  //  state()

   // viewModelState(MyViewModel())

   // theme()
  //  compositionLocal();

  //  constraintLayout()

   // eventLifecycle()

 //   animateVisibility()
//    animateEnterExit()
//    animateContent()
 //   crossfade()
  //  animateAlpha()
   // animateColor()
   // back()
//    render()
//    composition()
  //  jetpackComposeIsTooVerbose()
  //  jetpackComposeIsTooVerbose()
    //Hilt()

  //  presentViewModelWithLifecycle()
   // navigate()

  //  coroutinesViewModel()
  //  coroutinesInComposable()
   // coroutinesAsync()
 //   coroutinesFlow()
   // evenMoreCotroutines()

//    permissions()
 //   serviceWithFlow()

    coroutinesWithStop()
}

@Composable
fun coroutinesWithStop() {
    val lifecycleOwner = LocalLifecycleOwner.current;
    LaunchedEffect(Unit) {
        GlobalScope.launch {
            lifecycleOwner.repeatOnLifecycle(Lifecycle.State.DESTROYED) {
                println("[foo] DESTROYED")
            }
        }
    }
}


@HiltViewModel
class ViewModelWithHilt
    @Inject constructor(val scope: CoroutineScope)
    : ViewModel() {

    fun doAThing() {
        scope.launch {
            println("[foo] ViewModelWithHilt")
        }
    }
}

@Module
@InstallIn(SingletonComponent::class)
object myModuel {
    @Provides
    @Singleton
    fun providesScope(): CoroutineScope {
        return GlobalScope
    }
}

/*

fun evenMoreCotroutines() {

    val scope = CoroutineScope(Job() + Dispatchers.Main)
    val job1 = scope.launch {
        // New coroutine with CoroutineName = "coroutine" (default)
    }

    val job2 = scope.launch(Dispatchers.Default. + "BackgroundCoroutine") {
        // New coroutine with CoroutineName = "BackgroundCoroutine" (overridden)
    }
}
*/

@Composable
fun permissions() {
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Permission Accepted: Do something
            println("[foo]  PERMISSION GRANTED")

        } else {
            // Permission Denied: Do something
            println("[foo] PERMISSION DENIED")
        }
    }
    val context = LocalContext.current

    Button(
        onClick = {
            // Check permission
            when (PackageManager.PERMISSION_GRANTED) {
                ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.RECORD_AUDIO
                ) -> {
                    // Some works that require permission
                    println("[foo] Code requires permission")
                }
                else -> {
                    // Asking for permission
                    launcher.launch(Manifest.permission.RECORD_AUDIO)
                }
            }
        }
    ) {
        Text(text = "Check and Request Permission")
    }
}

/*
@Composable
fun permissions() {
    var per = ContextCompat.checkSelfPermission( LocalContext.current,  Manifest.permission.RECORD_AUDIO)
    println("[foo] permission ${per == PackageManager.PERMISSION_GRANTED}")

    if (per == PackageManager.PERMISSION_GRANTED) {
    */
/*    ActivityCompat.requestPermissions(LocalContext.current.getActivity(),
            arrayOf(Manifest.permission.RECORD_AUDIO),
            *//*
*/
/*RECORD_REQUEST_CODE*//*
*/
/*101)
        )*//*

    }
}

fun Context.getActivity(): AppCompatActivity? = when (this) {
    is AppCompatActivity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}
*/

@Composable
fun serviceWithFlow() {
    val service = ServiceWithFlow()

    // doesn't make sense because VMs shouldn't expose flow states
//    Text(service.myStr)

    // val liveData: MutableLiveData<String> = MutableLiveData(service.myStr.collectAsState().value)
    Button(onClick = { service.doAThing() }) {
        Text(service.myStr.collectAsState().value!!) // this leaks
    }
    /*
    val lifecycleOwner = LocalLifecycleOwner.current
    lifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
        service.myStr.collect { value = it }
    }*/
}

class ServiceWithFlow {
    val myStr = MutableStateFlow("hello world")

    fun doAThing() {
        GlobalScope.launch {
            delay(3_000)
            myStr.value = "foo"
        }
    }
}

fun coroutinesFlow() {
    lateinit var myStrEmitter: FlowCollector<String>
    val myStr: Flow<String> = flow { myStrEmitter = this }

    GlobalScope.launch {
        myStr.collect { println("[foo] coroutinesFlow $it") }
        myStrEmitter.emit("foo")
    }
}


fun coroutinesAsync() {
    GlobalScope.launch {
        coroutinesAsyncReturn()
    }
}

suspend fun coroutinesAsyncReturn() {
    val mainCoroutineScope = CoroutineScope(Dispatchers.Main)
    val x = mainCoroutineScope.async(Dispatchers.Default) {
        return@async coroutinesAsyncReturnReal()
    }
    println("[foo] returned ${x.await()}")
}

private suspend fun coroutinesAsyncReturnReal(): String {
    println("[foo]] start ${Thread.currentThread().name}")
    delay(5_000)
    println("[foo]] end ${Thread.currentThread().name}")
    return "foo"
}

fun coroutines() {
    val mainCoroutineScope = CoroutineScope(Dispatchers.Main)
    val ioCoroutineScope = CoroutineScope(Dispatchers.IO)
    val defaultCoroutineScope = CoroutineScope(Dispatchers.Default)
    val unconfinedCoroutineScope = CoroutineScope(Dispatchers.Unconfined)
    val viewModelScope = SomeViewModel().getViewModelScope()
    val globalScope = GlobalScope

    globalScope.launch {
        println("[foo] globalScope")
    }

    viewModelScope.launch {
        println("[foo] viewModelScope")
    }

    unconfinedCoroutineScope.launch {
        println("[foo] unconfinedCoroutineScope")
    }

    ioCoroutineScope.launch {
        println("[foo] ioCoroutineScope")
    }

    mainCoroutineScope.launch {
        println("[foo] mainCoroutineScope")
    }

    defaultCoroutineScope.launch {
        println("[foo] defaultCoroutineScope")
    }
}

@Composable
fun coroutinesInComposable() {
    val myLiveData = MutableLiveData("foo")

    Text(text = myLiveData.observeAsState().value!!)

    val lifecycleOwner = LocalLifecycleOwner.current
    myLiveData.observe(lifecycleOwner, Observer { println("[foo] $it") })

    runSuspendedFun(myLiveData)
}

fun runSuspendedFun(myLiveData: MutableLiveData<String>) {
    CoroutineScope(Dispatchers.Main).launch {
        suspendedFun(myLiveData)
    }
}

suspend fun suspendedFun(mutableLiveData: MutableLiveData<String>) {
    withContext(Dispatchers.IO) {
        println("[foo] starting")
        delay(3_000)
        println("[foo] done")
        val x = "bar"
      /*  withContext(Dispatchers.Main) {
                mutableLiveData.value = x
        }*/
    }
}

class SomeViewModel : ViewModel() {
    fun getViewModelScope(): CoroutineScope {
        return viewModelScope
    }

}

@Composable
fun navigate() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "page1") {
        composable("page1") {
            Button({
                navController.navigate("page2")
            }) {
                Text("iNavigate")
            }
        }
        composable("page2") {
            Column {
                Text(text = "oh no, I was navigated")
                Button(onClick = {
                    navController.navigate("page3/foo")
                }) {
                    Text("iNavigate with arg: foo")
                }
            }
        }
        composable("page3/{myArg}",
                arguments = listOf(navArgument("myArg", ) { type = NavType.StringType })) {
            Text("page3: ${it.arguments?.getString("myArg")}")
        }
        /*...*/
    }
}

@Composable
fun presentViewModelWithLifecycle() {
   //  val factory = SavedStateViewModelFactory(null, this.)
    val vm = TheViewModelFactory("hello world").create(TheViewModel::class.java)

    val l = LocalLifecycleOwner.current

    LocalLifecycleOwner.current.lifecycleScope.launchWhenCreated {
        println("[foo] launchWhenCreated")
     /*   l.lifecycleScope.launch {
       //     l.withStateAtLeast(Lifecycle.State.DESTROYED, { println("[foo] DESTROYED") })
            l.withStateAtLeast(Lifecycle.State.INITIALIZED, { println("[foo] INITIALIZED") })
        }*/
    }
    LocalLifecycleOwner.current.lifecycleScope.launchWhenResumed { println("[foo] launchWhenResumed") }
    LocalLifecycleOwner.current.lifecycleScope.launchWhenStarted { println("[foo] launchWhenStarted") }

   // LocalLifecycleOwner.current.withStateAtLeast(.) { println("[foo] whenCreated") }

    Button(onClick = vm::onClick) {
        Column {
            Text(text = vm.myStr.observeAsState().value!!)
        }
    }
}

class TheViewModelFactory(private val myStr: String): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T  {
        return TheViewModel(myStr) as T
    }
}


class TheViewModel(private val _myStr: String): ViewModel() {
    public val myStr = MutableLiveData(_myStr)


    public fun onClick() {
        myStr.value += " click"
    }
}

@Composable
fun Hilt() {

}

class Foo {
    //@Inject lateinit var bar: Bar
}

class Bar {

}


@Composable
fun jetpackComposeIsTooVerbose() {
    var isChecked by remember { mutableStateOf(false) }
    Checkbox(checked = isChecked, onCheckedChange = {
        isChecked = it
    })

/*    var text by remember { mutableStateOf("foo")}
    TextField(value = text, onValueChange = {
        text = it
    })*/

 /*   val numberItems = 1..1000
    LazyColumn() {
        items(numberItems.toList()) {
            Text("foo $it")
        }
    }*/
}



fun composition() {
   // MutableState
  //  Composition.
    /*Button(onClick = { *//*TODO*//* }) {
        
    }*/
}

/*@Composable
fun render() {
    val lifecycleOwner = LifecycleOwnerAmbient.current
    launchInComposition {
        val startTime = withFrameMillis { it }
        lifecycleOwner.whenStarted {
            while (true) {
                withFrameMillis { frameTime ->
                    millisState.value = frameTime - startTime
                }
            }
        }
    }
}*/

@Composable
fun back() {
    var enabledBackHandling by remember { mutableStateOf(true) }
    BackHandler(enabledBackHandling) {
        println("[foo] beep boop back button")
        enabledBackHandling = false
    }
}

@Composable
fun animateColor() {
    val color = remember { Animatable(Color.Green) }
    Box(
        Modifier
            .fillMaxSize()
            .background(color.value)) {
        Button(onClick = {
            GlobalScope.launch (Dispatchers.Default) {
                color.animateTo(Color.Blue)
            }
        }) {
            Text(text= "foo")
        }
    }
}

@Composable
fun animateAlpha() {
    var enabled by remember { mutableStateOf(true) }
    val alpha: Float by animateFloatAsState(if (enabled) 1f else 0.5f)
    Box(
        Modifier
            .fillMaxSize()
            .graphicsLayer(alpha = alpha)
            .background(Color.Red)) {
                Text(text = "foo", modifier = Modifier
                    .clickable { enabled = !enabled }
                )
            }
}

@Composable
fun crossfade() {
    var text by remember { mutableStateOf(LocalDateTime.now()) }
    Column(modifier = Modifier) {
        Crossfade(text) { foo ->
            Text(text = "Count: $foo")
        }
        Button(onClick = { text = LocalDateTime.now() }) {
            Text(text = "click me")
        }
    }

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun animateContent() {
    Box(modifier = Modifier
        .fillMaxSize()) {
        var text by remember { mutableStateOf(LocalDateTime.now()) }
        AnimatedContent(text) {
            Text(text = "Count: $text",
                modifier = Modifier.clickable {
                    text = LocalDateTime.now()
                })
        }
        /*Column {
            var count by remember { mutableStateOf(0) }
            Button(onClick = { count++ }) {
                Text("Add")
            }
            AnimatedContent(targetState = count) { targetCount ->
                // Make sure to use `targetCount`, not `count`.
                Text(text = "Count: $targetCount")
            }
        }*/
    }
}

/*
@Composable
fun animateEnterExit() {
    var visibility by remember { mutableStateOf(true )}
    AnimatedVisibility(visible = visibility, exit = fadeOut()) {
        Box(modifier = Modifier.fillMaxSize().background(Color.Blue)) {
            Box(
                Modifier.align(Alignment.Center)
                    .sizeIn(minWidth = 256.dp, minHeight = 64.dp)
                    .background(Color.Red)
                    .animateEnterExit()

            ) {
                Text(text = "foo")
                Text(text = "bar")
            }
        }
    }
}
*/

@Composable
fun animateVisibility() {
    Box(modifier = Modifier.fillMaxSize()) {
        var visibility by remember { mutableStateOf(true )}
        AnimatedVisibility(visible = visibility, exit = fadeOut()) {
            Text(text = "foo", modifier = Modifier.clickable {
                visibility = !visibility
            })
        }
    }
}

@Composable
fun eventLifecycle() {
    Box(modifier = Modifier
        .clickable { println("[foo] modifier click ") }
        .fillMaxHeight()
        .fillMaxWidth()
        .background(androidx.compose.ui.graphics.Color.Green)
        .drawWithContent { println("[foo] drawWithContent ") }
        .drawBehind { println("[foo] drawBehind") }
        .graphicsLayer { println("[foo] graphicsLayer") }
        .onGloballyPositioned { println("[foo] onGloballyPositioned") }
        .onPlaced { println("[foo] onPlaced ${it.size} ${it.isAttached}") }
        .onSizeChanged { println("[foo] onSizeChanged $it") }
        .semantics { println("[foo] semantics") }
        .onFocusEvent { println("[foo] onFocusEvent ${it.hasFocus}") }

    ) {
        LaunchedEffect(Unit) {
            println("[foo] LaunchedEffect")
        }

        Text(text = "foo")

        SideEffect {
            println("[foo] SideEffected")
        }
    }

}


@Composable
fun constraintLayout() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (fooRef, barRef, bazRef, fooRef2) = createRefs()

        Text("foo", modifier = Modifier.constrainAs(fooRef) {
            centerVerticallyTo(parent)
            start.linkTo(parent.start)
        })
        Text("bar", modifier = Modifier.constrainAs(barRef) {
            top.linkTo(fooRef.bottom)
            end.linkTo(parent.end)
        })
        Text("baz", modifier = Modifier.constrainAs(bazRef) {
            bottom.linkTo(parent.bottom)
            centerHorizontallyTo( parent)
        })

        val startGuideline = createGuidelineFromStart(16.dp)
        val middleGuideline = createGuidelineFromTop(0.4f)
        Text("foo2", modifier = Modifier.constrainAs(fooRef2) {
            top.linkTo(middleGuideline)
            start.linkTo(startGuideline)
        })
    }
}




data class MyLocalComposition(val myInt: Int = 123)

val myLocalComposition = compositionLocalOf { MyLocalComposition() }

@Composable
fun compositionLocal() {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text("foo")
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
            Text("bar")
        }

        CompositionLocalProvider(myLocalComposition provides MyLocalComposition(456)) {
            Text("baz ${myLocalComposition.current.myInt}")
        }
    }
}

@Composable
fun theme() {
    Column(Modifier.fillMaxSize()) {
        Compose_test_3Theme() {
            MyTextField()
            button()
            myRadioGroup()
            fab()
            progress()
        }
        MaterialTheme() {
            MyTextField()
            button()
            myRadioGroup()
            fab()
            progress()
        }
    }
}

class MyViewModel: ViewModel() {
    public var count: MutableLiveData<Int> = MutableLiveData(0)

    public fun onClick() {
        count.value = count.value!! + 1;
    }
}

@Composable
fun viewModelState(myViewModel: MyViewModel) {
    val count = myViewModel.count.observeAsState()

    vmStateHoistingChild(state = count.value!!, event = myViewModel::onClick)
}

@Composable
fun vmStateHoistingChild(state: Int, event: () -> Unit) {
    Box(modifier = Modifier
        .clickable(onClick = event)
        .fillMaxWidth()) {
        Text(text = "state $state")
    }
}



@Composable
fun state() {
    var count by rememberSaveable { mutableStateOf(0) }

    stateHoistingChild(state = count) {
        count++
    }
}

@Composable
fun stateHoistingChild(state: Int, event: () -> Unit) {
    Box(modifier = Modifier
        .clickable(onClick = event)
        .fillMaxWidth()) {
        Text(text = "state $state")
    }
}

@Composable
fun modifiers() {
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(androidx.compose.ui.graphics.Color.Green)
        .clickable { println("[foo] modifier click ") }
        .drawWithContent { println("[foo] drawWithContent ") }
        .drawBehind { println("[foo] drawBehind") }
        .graphicsLayer { println("[foo] graphicsLayer") }
        .onGloballyPositioned { println("[foo] onGloballyPositioned") }
        .onPlaced { println("[foo] onPlaced $it.") }
        .onSizeChanged { println("[foo] onSizeChanged $it") }

    ) {

        Text(text = "foo")
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun grid() {
    val numberItems = 1..1000
  //  var count = 0
    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp)) {
        items(numberItems.toList()) {
            Text("foo $it")
//            count++
//            println("[foo] count $count $it")
        }
    }
}

@Composable
private fun lazyColumn() {
    val numberItems = 1..1000
    LazyColumn() {
        items(numberItems.toList()) {
            Text("foo $it")
        }
    }
}

@Composable
private fun scroll() {
    val foo by remember { mutableStateOf<ScrollState>(ScrollState(0)) }

    val items = 1..1000
    Column(modifier = Modifier.verticalScroll(foo)) {
        items.forEach {
            Text("foo $it")
        }
    }
}

@Composable
fun scaffold() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = { SnackbarHost(scaffoldState.snackbarHostState) },
        floatingActionButton = {
            var clickCount by remember { mutableStateOf(0) }
            FloatingActionButton(
                onClick = {
                    // show snackbar as a suspend function
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            "Snackbar # ${++clickCount}"
                        )
                    }
                }
            ) { Text("Show snackbar") }
        },
        topBar = {
            TopAppBar(title = {
                Box(modifier = Modifier.clickable { scope.launch {
                    if (scaffoldState.drawerState.isOpen)
                        scaffoldState.drawerState.close()
                    else
                        scaffoldState.drawerState.open()
                }}) {
                    Text(text = "foo")
                }
            })
         },
        bottomBar = { BottomAppBar() {
            Text(text = "bar")
        } },
        drawerContent = { Text(text = "baz") },
        content = { innerPadding ->
            Text(
                text = "Body content",
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .wrapContentSize()
            )
        }
    )
}

@Composable
fun column() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "foo")
        Text(text = "bar")
        Text(text = "baz")
    }

}

@Composable
fun row() {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()) {
        Text(text = "foo")
        Text(text = "bar")
        Text(text = "baz")
    }
}

@Composable
fun progress() {
    CircularProgressIndicator(
       // color = colorResource(id = R.color.purple_700),
        strokeWidth = 5.dp
    )
    LinearProgressIndicator(progress = 0.5f)
}

@Composable
fun fab() {
    FloatingActionButton(onClick = { println("onClickFab") },
        content = { Text(text = "+") }
    )
}

@Composable
private fun button() {
    Button(
        onClick = { println("boink") },
        colors = ButtonDefaults.buttonColors()
    ) {
        Text(text = "boink")
    }
}

@Composable
fun myRadioGroup() {
    val radioButtons = listOf(0, 1, 2)
    val selectedButton = remember { mutableStateOf(radioButtons.first()) }
    Column {
        radioButtons.forEach { index ->
            val isSelected = index == selectedButton.value
            RadioButton(
                selected = isSelected,
                onClick = { selectedButton.value = index }
            ) } }
    }

@Composable
fun SimpleFilledTextFieldSample() {
    var text by remember { mutableStateOf("Hello World") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone)
    )
}

@Composable
fun MyTextField() {
    val textValue = remember { mutableStateOf("foo@bar.com") }
    val primaryColor = colorResource(id = R.color.purple_700)
    OutlinedTextField(
        label = { Text(text = "email") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = primaryColor,
            focusedLabelColor = primaryColor,
            cursorColor = primaryColor
        ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
    ) }

@Composable
fun renderClass(myClass: MyClass) {
    Box(modifier = Modifier.clickable { println("onClick") }) {
        Text(text = myClass.myStr)
    }
}

class MyClass(var myStr: String) {

}

@Composable
fun TextImageButton(text: String) {
    Box(modifier = Modifier.clickable(onClick = { println("onClick") })) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(painterResource(id = androidx.core.R.drawable.notification_bg),
                contentDescription = "")
            Text(text = text)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

