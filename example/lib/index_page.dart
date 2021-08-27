import 'package:flutter/material.dart';
import 'package:flutter_minemap_example/view/base_map_page.dart';
import 'package:flutter_minemap_example/view/cluster_layer_page.dart';
import 'package:flutter_minemap_example/view/map_style_page.dart';

class IndexPage extends StatefulWidget {
  const IndexPage({Key key}) : super(key: key);

  @override
  _IndexPageState createState() => _IndexPageState();
}

class _IndexPageState extends State<IndexPage> {
  List<BTNWidgetClass> _btnList = [];

  @override
  void initState() {
    super.initState();
    _setBtnList();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Plugin example app'),
      ),
      body: ListView.builder(
        itemCount: _btnList.length,
        itemBuilder: (BuildContext context, int i) {
          if (_btnList[i].title.isEmpty) {
            return Container(
              width: MediaQuery.of(context).size.width,
              height: 35,
              alignment: Alignment.centerLeft,
              padding: EdgeInsets.symmetric(horizontal: 20),
              decoration: BoxDecoration(color: Colors.amberAccent),
              child: Text(
                _btnList[i].subtitle,
                style: TextStyle(
                  fontSize: 16,
                ),
              ),
            );
          } else {
            return _btnWidget(_btnList[i]);
          }
        },
      ),
    );
  }

  Widget _btnWidget(BTNWidgetClass d) {
    return ListTile(
      // contentPadding: EdgeInsets.symmetric(),
      onTap: d.func,
      title: Text(
        d.title,
        style: TextStyle(
          fontSize: 16,
        ),
      ),
      subtitle: Text(d.subtitle),
    );
  }

  void _setBtnList() {
    _btnList = [
      BTNWidgetClass(
        '',
        '基础地图',
        () => Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => BaseMapPage()),
        ),
      ),
      BTNWidgetClass('基础地图', '地图视角边界', () {}),
      BTNWidgetClass('边界', '地图视角边界', () {}),
      BTNWidgetClass('Fragment', '如何制作一个Fragment', () {}),
      BTNWidgetClass('', '交互事件', () {}),
      BTNWidgetClass('地图基础操作', '介绍地图的基础操作', () {}),
      BTNWidgetClass('UI控制功能', '介绍UI的基本操作和控件的显示隐藏操作', () {}),
      BTNWidgetClass(
        '地图样式设置',
        '介绍地图样式设置方法',
        () => Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => MapStylePage()),
        ),
      ),
      BTNWidgetClass('视角移动', '介绍地图的两种移动视角的方式', () {}),
      BTNWidgetClass('坐标转换', '介绍坐标转换的方法', () {}),
      BTNWidgetClass('距离测量', '介绍测距测面积的方法', () {}),
      BTNWidgetClass('', '简单覆盖物', () {}),
      BTNWidgetClass('点', '往地图上添加简单点', () {}),
      BTNWidgetClass('Polygon', '往地图上添加多边形', () {}),
      BTNWidgetClass('', '复杂覆盖物', () {}),
      BTNWidgetClass('圆', '往地图上添加圆', () {}),
      BTNWidgetClass('点-marklayer', '往地图上添加复杂点', () {}),
      BTNWidgetClass('点-marklayer', '如何修改文字特殊效果', () {}),
      BTNWidgetClass('PolylineLayer', '往地图上添加线段层', () {}),
      BTNWidgetClass('三维建筑物', '如何往地图上添加3D建筑物', () {}),
      BTNWidgetClass('复杂多边形', '如何往地图上添加3D多边形', () {}),
      BTNWidgetClass('混合', '覆盖物的混合模式,看是否会有干扰', () {}),
      BTNWidgetClass('', '混合', () {}),
      BTNWidgetClass('混合航线图', '往地图上添加混合航线图层', () {}),
      BTNWidgetClass('混合wmts图像图', '往地图上添加混合wmts图像图层', () {}),
      BTNWidgetClass('', '拓展覆盖物', () {}),
      BTNWidgetClass('光晕圈', '往地图上添加光晕圈图层', () {}),
      BTNWidgetClass('大规模图标图', '往地图上添加大规模图标', () {}),
      BTNWidgetClass('热力图', '', () {}),
      BTNWidgetClass('柱状图', '往地图上添加柱状图层', () {}),
      BTNWidgetClass(
        '点聚合图',
        '往地图上添加点聚合图层',
        () => Navigator.push(
          context,
          MaterialPageRoute(builder: (_) => ClusterLayerPage()),
        ),
      ),
      BTNWidgetClass('波形圈', '往地图上添加波形圈图层', () {}),
      BTNWidgetClass('OD迁徙图', '往地图上添加OD迁徙图层', () {}),
      BTNWidgetClass('航线地图', '往地图上添加航线图层', () {}),
      BTNWidgetClass('wmts图像图', '往地图上添加混合wmts图像图层', () {}),
      BTNWidgetClass('导航线图', '往地图上添加导航线', () {}),
      BTNWidgetClass('水纹图', '水纹特效', () {}),
      BTNWidgetClass('大规模图标图', '往地图上添加大规模散点图层', () {}),
      BTNWidgetClass('点平滑移动', '往地图上添加点平滑移动图层', () {}),
    ];
  }
}

class BTNWidgetClass {
  final String title;
  final String subtitle;
  final Function func;

  BTNWidgetClass(this.title, this.subtitle, this.func);
}
