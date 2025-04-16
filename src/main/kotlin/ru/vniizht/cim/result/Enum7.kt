import java.time.LocalDateTime
import java.util.*

/** Состояния внедрения */
enum class DeploymentStateKind {
    /** Монтаж не завершен */
    notYetInstalled,
    /** Монтаж завершен */
    installed,
    /** В работе */
    inService,
    /** Не в работе */
    outOfService,
    /** Демонтирован */
    removed
}

/** Вид клиента */
enum class CustomerKind {
    /** Коммерческий промышленный */
    commercialIndustrial,
    /** Диспетчер энергетических услуг */
    energyServiceScheduler,
    /** Поставщик энергетических услуг */
    energyServiceSupplier,
    /** Внутреннего использования */
    internalUse,
    /** Другой */
    other,
    /** Насосная станция */
    pumpingLoad,
    /** Бытовой */
    residential,
    /** Бытовой и коммерческий */
    residentialAndCommercial,
    /** Бытовой и уличное освещение */
    residentialAndStreetlight,
    /** Сельское хозяйство */
    residentialFarmService,
    /** Бытовое уличное освещение или другой связанный клиент */
    residentialStreetlightOthers,
    /** Ветряная машина */
    windMachine
}