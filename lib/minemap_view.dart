import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter/services.dart';
import 'package:flutter_minemap/models/fmm_map_options.dart';

import 'mimemap_controler.dart';

typedef void MineMapViewCreatedCallback(MineMapController controller);

class MineMapView extends StatefulWidget {
  const MineMapView({
    Key key,
    @required this.onMineMapViewCreated,
    @required this.mapOptions,
  }) : super(key: key);

  final MineMapViewCreatedCallback onMineMapViewCreated;

  /// map属性配置
  final FMMMapOptions mapOptions;

  @override
  _MineMapViewState createState() => _MineMapViewState();
}

class _MineMapViewState extends State<MineMapView> {
  final String viewType = 'flutter_minemap/map/FMMMapView';

  @override
  Widget build(BuildContext context) {
    return Container(
      width: double.infinity,
      height: double.infinity,
      child: _isPlatFrom(),
    );
  }

  Widget _isPlatFrom() {
    if (Platform.isIOS) {
      return UiKitView(
        viewType: viewType,
        creationParams: widget.mapOptions.toMap() as dynamic, // 向视图传递参数
        creationParamsCodec: StandardMessageCodec(),
        onPlatformViewCreated: _onPlatformViewCreated,
      );
    } else if (Platform.isAndroid) {
      return AndroidView(
        viewType: viewType,
        creationParams: widget.mapOptions.toMap() as dynamic, // 向视图传递参数
        creationParamsCodec: StandardMessageCodec(),
        onPlatformViewCreated: _onPlatformViewCreated,
      );
    } else {
      return Container(
        alignment: Alignment.center,
        child: Text(
          'You are using an unsupported platform. Only IOS and Android are supported.',
        ),
      );
    }
  }

  void _onPlatformViewCreated(int id) {
    if (widget.onMineMapViewCreated == null) {
      return;
    }
    widget.onMineMapViewCreated(MineMapController.withId(id));
  }
}
