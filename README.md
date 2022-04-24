# EasyMessagePack
让数据更小，更快。

MessagePack原生使用方法及其繁杂，使用此库可以通过一个方法即可序列化/反序列化。

帮助你轻松将Bean数据通过MessagePack打包为二进制数据。而且是无key模式！效果比MessagePack官方宣传的只是比Json去掉几个标点符号效果要更好。

此库由 https://github.com/Attect/Android-Framework666 的缓存引擎分离而来



## 特点

- 直接对象处理速度快，比Json快（以Gson作为参考对比）（更新Field强制排序处理后，首次缓存创建前与Gson速度接近）
- 体积小，无Key模式，只保存Value，靠顺序和flag准确序列化和反序列化
- 支持内部类，简单层级的内部类支持，让数据还原后依然能保持父子关系
- Java也能支持大部分特性，大部分方法Java也能使用
- 特定数据，提供接口可定制序列化和反序列化步骤
- 支持数据可null



## 对比

### Json

`{"valData":0,"id":6385678,"username":"Attect","book":{"name":"C+++","page":1000},"score":[1,2,3],"backpack":[{"name":"Chinese","page":5000},{"name":"Math","page":200}],"cards":[[{"name":"joker","level":"R","price":1},{"name":"Faker","level":"R","price":1}],[{"name":"Tom","level":"SR","price":1},{"name":"Jerry","level":"SR","price":1}]],"map":{"美国":"新乡","广东":"深圳","广西":"南宁"},"cityMap":{"美国":["新乡","西单"],"韩国":["汉城"],"中国":["北京","上海","成都","长沙"]},"array":[{"name":"Kotlin","page":999}],"nullableThing":{"thing":{"v":"success"},"v":"not set"}}`

### 去掉Key的MessagePack

`�� ap�Attect¤C+++���§Chinese��¤Math��Ò�¥joker�R¥Faker�R�£Tom�SR¥Jerry�SR��美国�新乡�广东�深圳�广西�南宁��美国��新乡�西单�韩国��汉城�中国��北京�上海�成都�长沙¦Kotlin����çsuccess�not set`

### 性能对比
(此项数据待重新验证，新电脑太快了都是0ms)

| 对比         | Json    | EasyMessagePack |
| ------------ | ------- | --------------- |
| 序列化时间   | 18ms    | 1ms             |
| 反序列化时间 | 9ms     | 2ms             |
| 数据长度     | 539字节 | 236字节         |



## 特性说明

- val声明的变量不会被操作(final)
- 透明声明的变量不会被操作（Transient）
- 静态变量不会被操作（const/static）
- Kotlin委托不会被操作(final)
- 内部类仅支持一层，即父类下直接使用子类，不支持跨类调用，也不支持在父类的子类A中使用父类的子类B
- 严格的顺序，因为没有key，读写用的Bean中字段类型和数量一定要一致，如果你希望版本迭代，请参考 https://github.com/Attect/Android-Framework666/blob/master/framework666/src/main/java/studio/attect/framework666/extensions/Context.kt 中关于缓存的有效性检查的实现



## 使用

此项目打包后的jar仅包含自身逻辑代码，因此还需要添加msgpack-core依赖

`org.msgpack:msgpack-core:0.9.1`

版本号可有变化



例子请参考

https://github.com/Attect/EasyMessagePack/blob/master/test/EasyMessagePackTest.kt



如果你需要对序列化后的二进制数据进行查错，可以使用我的另一个开源项目

https://github.com/Attect/Framework666CacheDataXPreviewer
