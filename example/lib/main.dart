import 'package:flutter/material.dart';
import 'package:flutter_minemap_example/index_page.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {

  @override
  void initState() {
    super.initState();
  }


  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'FlutterMinemap',
      home: IndexPage(),
    );
  }
}

