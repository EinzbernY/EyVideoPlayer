# EyVideoPlayer介绍文档

![本地路径](ic_launcher.png "图标")

------

**目录介绍**

- 视频播放器介绍
- 架构说明

------

#### **视频播放器介绍**

可在MediaPlayer、ExoPlayer、IjkPlayer自由切换

| 播放器功能         | MediaPlayer | ExoPlayer | IjkPlayer |
| ------------------ | ----------- | --------- | --------- |
| 切换视频播放模式   | 支持        | 支持      | 支持      |
| 调节播放进度       | 支持        | 支持      | 支持      |
| 手势改变亮度/声音  | 支持        | 支持      | 支持      |
| 设置视频比例       | 支持        | 支持      | 支持      |
| 自由切换播放器内核 | 支持        | 支持      | 支持      |
| 记录播放位置       | 支持        | 支持      | 支持      |
| 重力感应           | 支持        | 支持      | 支持      |
| 锁定屏幕           | 支持        | 支持      | 支持      |
| 倍速               | 支持        | 支持      | 支持      |
| 小窗               | 支持        | 支持      | 支持      |
| 缓存               | 支持        | 支持      | 支持      |
| 全屏显示电量       | 支持        | 支持      | 支持      |
|                    |             |           |           |

------

#### 架构说明

- 可以切换ExoPlayer、MediaPlayer，IjkPlayer，使用工厂模式Factory + AbstractVideoPlayer + 实现AbstractVideoPlayer抽象类的播放器类。
- 可以自由切换视频内核，Player+Controller。player负责播放的逻辑，Controller负责视图相关的逻辑。
- 定义一个BaseVideoController类，这个主要是集成各种事件的处理逻辑。

