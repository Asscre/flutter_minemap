import 'package:flutter/material.dart';
import 'package:flutter_minemap/flutter_minemap.dart';
import 'package:flutter_minemap/minemap_view.dart';
import 'package:flutter_minemap/models/fmm_map_models.dart';
import 'package:flutter_minemap/models/fmm_types.dart';
import 'package:flutter_minemap_example/config/config.dart';

class BaseMapPage extends StatelessWidget {
  const BaseMapPage({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    MineMapController _mineMapController;

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
}
