import 'dart:io';
import 'dart:typed_data';

class FMMMapConveter {
  Future<ByteData> getImgByteData(String path) {
    Future<ByteData> byteData = File(path).readAsBytes().then((value) => value.buffer.asByteData());
    return byteData;
  }
}