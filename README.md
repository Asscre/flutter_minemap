# flutter_minemap

MineData地图组件 Flutter插件

## 依赖
> dependencies:
    flutter:
    sdk: flutter
    flutter_minemap: ^x.x.x

## 例子

> 设置accessToken、offlineAccessToken、solution

```dart
import 'package:flutter/material.dart';
import 'package:flutter_minemap/flutter_minemap.dart';

class MapDemoPage extends StatefulWidget {
  MapDemoPage({Key key}) : super(key: key);

  @override
  _MapDemoPageState createState() => _MapDemoPageState();
}

class _MapDemoPageState extends State<MapDemoPage> {
  MineMapController _mineMapController;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('地图'),
      ),
      body: Container(
        height: double.infinity,
        width: double.infinity,
        alignment: Alignment.center,
        child: MineMapView(
          mapOptions: FMMMapOptions(
            accessToken: '',
            offlineAccessToken: '',
            solution: '',
          ),
          onMineMapViewCreated: (MineMapController controller) {
            _mineMapController = controller;
          },
        ),
      ),
    );
  }
}
```