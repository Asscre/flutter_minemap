import 'package:flutter/material.dart';
import 'package:flutter_minemap/flutter_minemap.dart';
import 'package:flutter_minemap/minemap_view.dart';
import 'package:flutter_minemap/models/fmm_map_models.dart';
import 'package:flutter_minemap/models/fmm_types.dart';
import 'package:flutter_minemap_example/config/config.dart';

class BaseMapPage extends StatefulWidget {
  const BaseMapPage({Key key}) : super(key: key);

  @override
  _BaseMapPageState createState() => _BaseMapPageState();
}

class _BaseMapPageState extends State<BaseMapPage> {
  MineMapController _mineMapController;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('地图'),
      ),
      body: Column(
        children: [
          _mapWidget(),
          _makeWidget(context),
        ],
      ),
    );
  }

  Widget _mapWidget() {
    return Expanded(
      child: Container(
        width: MediaQuery.of(context).size.width,
        alignment: Alignment.center,
        child: MineMapView(
          mapOptions: FMMMapOptions(
            mapType: FMMMapType.Satellite,
            offlineAccessToken: Config.offlineAccessToken,
            accessToken: Config.accessToken,
            solution: Config.solution,
            center: FMMCoordinate(38.913828, 116.405419),
            logoEnabled: false,
          ),
          onMineMapViewCreated: (MineMapController controller) {
            _mineMapController = controller;
          },
        ),
      ),
    );
  }

  Widget _makeWidget(BuildContext context) {
    final List<CustomButtonModel> _btnL = [
      CustomButtonModel(
          '北京',
          () => _mineMapController
              .setMapCenter(FMMCoordinate(39.914687, 116.403613))),
      CustomButtonModel(
          '上海',
          () => _mineMapController
              .setMapCenter(FMMCoordinate(31.233706, 121.477091))),
      CustomButtonModel(
          '济南',
          () => _mineMapController
              .setMapCenter(FMMCoordinate(36.656786, 117.122375))),
      CustomButtonModel(
          '珠海',
          () => _mineMapController
              .setMapCenter(FMMCoordinate(22.26827, 113.573358))),
    ];

    List<Widget> _l = [];

    for (CustomButtonModel e in _btnL) {
      _l.add(TextButton(
        onPressed: e.func,
        child: Text(e.name),
      ));
    }

    return Container(
      width: MediaQuery.of(context).size.width,
      child: Wrap(
        children: _l,
      ),
    );
  }
}

class CustomButtonModel {
  final String name;
  final Function func;

  CustomButtonModel(this.name, this.func);
}
