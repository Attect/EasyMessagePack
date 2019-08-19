package studio.attect.easymessagepack

/**
 * 能被缓存数据处理办公室处理的档案X
 * 以下两个操作必须对称，且顺序一致
 * @author Attect
 */
interface CustomPackData {
    fun packTo(easyMessagePack: EasyMessagePack)

    fun unpackFrom(easyMessagePack: EasyMessagePack)
}