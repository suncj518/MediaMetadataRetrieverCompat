# MediaMetadataRetrieverCompat
多媒体元数据兼容方案 - 支持获取视频缩略图、视频信息  

## __简介__
MediaMetadataRetrieverCompat 内部有两种实现(根据自身需求选择初始化方式)  

`FFmpegMediaMetadataRetriever`  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;基于[FFmpegMediaMetadataRetriever](https://github.com/wseemann/FFmpegMediaMetadataRetriever)，体积大但取帧速度快  

`MediaMetadataRetriever`   
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;基于原生API，不会增加apk体积但取帧慢


## __示例apk__
![](screenshot/example-download.png)

## __效果演示__
![](screenshot/screenshot_auto.gif)
![](screenshot/screenshot_ffmpeg.gif)
![](screenshot/screenshot_android.gif)

## __快速开始__
```
//核心库 必选
implementation 'com.dyhdyh.compat.mmrc:media-metadata-retriever-compat:1.0.7'

//当需要FFmpegMediaMetadataRetriever时必选
implementation 'com.dyhdyh.remake:FFmpegMediaMetadataRetriever-java:1.0.14'
implementation 'com.dyhdyh.remake:FFmpegMediaMetadataRetriever-armeabi-v7a:1.0.14'

//可选平台
implementation 'com.dyhdyh.remake:FFmpegMediaMetadataRetriever-armeabi:1.0.14'
implementation 'com.dyhdyh.remake:FFmpegMediaMetadataRetriever-arm64-v8a:1.0.14'
implementation 'com.dyhdyh.remake:FFmpegMediaMetadataRetriever-mips:1.0.14'
implementation 'com.dyhdyh.remake:FFmpegMediaMetadataRetriever-x86:1.0.14'
implementation 'com.dyhdyh.remake:FFmpegMediaMetadataRetriever-x86_64:1.0.14'
```

## __初始化（三种模式）__
```
//自动 - 推荐  
MediaMetadataRetrieverCompat mmrc = MediaMetadataRetrieverCompat.create();  
//FFmpeg  
//MediaMetadataRetrieverCompat  mmrc = MediaMetadataRetrieverCompat.create(MediaMetadataRetrieverCompat.RETRIEVER_FFMPEG);  
//原生API  
//MediaMetadataRetrieverCompat  mmrc = MediaMetadataRetrieverCompat.create(MediaMetadataRetrieverCompat.RETRIEVER_ANDROID);
```
## __设置输入源__
```
//本地文件
mmrc.setDataSource(inputFile);

//网络视频(建议放在子线程)
mmrc.setDataSource(url, headers);

//Uri
mmrc.setDataSource(context, uri);
```

## __获取Metadata信息__
```
String width = mmrc.extractMetadata(MediaMetadataRetrieverCompat.METADATA_KEY_VIDEO_WIDTH);
String height = mmrc.extractMetadata(MediaMetadataRetrieverCompat.METADATA_KEY_VIDEO_HEIGHT);
String rotation = mmrc.extractMetadata(MediaMetadataRetrieverCompat.METADATA_KEY_VIDEO_ROTATION);
String numTracks = mmrc.extractMetadata(MediaMetadataRetrieverCompat.METADATA_KEY_NUM_TRACKS);
String title = mmrc.extractMetadata(MediaMetadataRetrieverCompat.METADATA_KEY_TITLE);
String album = mmrc.extractMetadata(MediaMetadataRetrieverCompat.METADATA_KEY_ALBUM);
String albumArtist = mmrc.extractMetadata(MediaMetadataRetrieverCompat.METADATA_KEY_ALBUMARTIST);
String author = mmrc.extractMetadata(MediaMetadataRetrieverCompat.METADATA_KEY_AUTHOR);
String duration = mmrc.extractMetadata(MediaMetadataRetrieverCompat.METADATA_KEY_DURATION);
String framerate = mmrc.extractMetadata(MediaMetadataRetrieverCompat.METADATA_KEY_CAPTURE_FRAMERATE);
...
```

## __获取本地视频缩略图__
耗时操作，请放在子线程  

```
//获取第一帧原尺寸图片
mmrc.getFrameAtTime();

//获取指定位置的原尺寸图片 注意这里传的timeUs是微秒
mmrc.getFrameAtTime(timeUs, option);

//获取指定位置指定宽高的缩略图
mmrc.getScaledFrameAtTime(timeUs, MediaMetadataRetrieverCompat.OPTION_CLOSEST, width, height);

//获取指定位置指定宽高并且旋转的缩略图
mmrc.getScaledFrameAtTime(timeUs, MediaMetadataRetrieverCompat.OPTION_CLOSEST, width, height, rotate);
```
