import 'package:flutter/material.dart';
import 'package:flutter_minemap/flutter_minemap.dart';
import 'package:flutter_minemap/models/fmm_map_models.dart';
import 'package:flutter_minemap/models/fmm_types.dart';
import 'package:flutter_minemap_example/common/scaffold_widget.dart';
import 'package:flutter_minemap_example/config/config.dart';

class ClusterLayerPage extends StatefulWidget {
  const ClusterLayerPage({Key key}) : super(key: key);

  @override
  _ClusterLayerPageState createState() => _ClusterLayerPageState();
}

class _ClusterLayerPageState extends State<ClusterLayerPage> {
  MineMapController _mineMapController;

  @override
  Widget build(BuildContext context) {
    return ScaffoldWidget(
      title: '点聚合图',
      child: Column(
        children: [_map(), _btnListWidget()],
      ),
    );
  }

  Widget _map() {
    return Expanded(
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
    );
  }

  Widget _btnListWidget() {
    final List<ClusterLayerPageBtnModel> _btnL = [
      ClusterLayerPageBtnModel(
          '添加聚合点图层', () => _mineMapController.addClusterLayer()),
      ClusterLayerPageBtnModel('添加聚合点图层集合', () {}),
      ClusterLayerPageBtnModel('清空聚合点图层', () {}),
      ClusterLayerPageBtnModel('删除聚合点图层', () {}),
    ];

    List<Widget> _l = [];

    for (ClusterLayerPageBtnModel e in _btnL) {
      _l.add(Expanded(
        child: TextButton(
          onPressed: e.func,
          child: Text(e.name),
        ),
      ));
    }

    return Container(
      height: 60,
      width: MediaQuery.of(context).size.width,
      child: Row(
        children: _l,
      ),
    );
  }
}

class ClusterLayerPageBtnModel {
  final String name;
  final Function func;

  ClusterLayerPageBtnModel(this.name, this.func);
}
