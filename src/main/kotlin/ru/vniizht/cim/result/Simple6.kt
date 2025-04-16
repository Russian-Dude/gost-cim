import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Строка таблицы зависимости эксплуатационных ограничений/пределов от температуры */
class TemperatureDependentLimitPoint(
    /** Допустимость интерполяции при промежуточных значениях температуры (по умолчанию - "истина").
    При недопустимости интерполяции для промежуточных значений температур принимаются указанные значения для ближайшей большей температуры */
    val rf_interpolation: Boolean,
    /** Отношение значения эксплуатационного ограничения/предела для заданной температуры к нормальному значению эксплуатационного ограничения/предела, % */
    val limitPercent: Double,
    /** Температура, °C */
    val temperature: Double,
    /** Таблица зависимости эксплуатационных ограничений/пределов от температуры */
    val temperatureDependentLimitTable: TemperatureDependentLimitTable
)

/** Пара "имя - значение", специфичная для событий конечного устройства */
class EndDeviceEventDetail(
    /** Наименование */
    val name: String,
    /** Значение */
    val value: StringQuantity
)

/** Точка в заданном пространстве, связанная с элементом схемы и определяемая координатами x, y, z */
class DiagramObjectPoint(
    /** Порядковый номер точки при отрисовке элемента схемы */
    val sequenceNumber: Int,
    /** Координата по оси X */
    val xPosition: Double,
    /** Координата по оси Y */
    val yPosition: Double,
    /** Координата по оси Z */
    val zPosition: Double,
    /** Элемент схемы, связанный с одной точкой или группой точек */
    val diagramObject: DiagramObject,
    /** Совокупность группы точек, в которую входят точки, связанные с различными элементами схемы */
    val diagramObjectGluePoint: DiagramObjectGluePoint?
)

/** Тип прав доступа */
class ICCPAccessPrivilegeKind(
    /** Права "Только чтение". Указывает на запрет изменения значения точки ICCP (ICCPPoint) другой стороной */
    val readOnly: Any,
    /** Права "Чтение и запись". Указывает на возможность не только получения значения точки ICCP другой стороной, но и изменения ее значения */
    val readWrite: Any
)

/** Аналоговый параметр, значения которого являются непрерывной функцией изменений измеряемой, вычисляемой либо иной величины */
class Analog(
    /** Максимальное значение нормального диапазона допустимого значения для измерения */
    val maxValue: Double,
    /** Минимальное значение нормального диапазона допустимого значения для измерения */
    val minValue: Double,
    /** Нормальное измеренное значение, например, использованное в процентных расчетах */
    val normalValue: Double,
    /** Указывает, что положительное значение перетока мощности или тока соответствует направлению извне в полюс оборудования */
    val positiveFlowIn: Boolean,
    /** Значения аналоговых измерений */
    val analogValues: Array<AnalogValue>,
    /** Аналоговые каналы осциллограмм, регистрирующие параметры в данной точке измерения */
    val analogChannels: Array<rf_AnalogChannel>,
    override val analog: Any,
    override val discrete: Any,
    override val measurementType: String,
    override val phases: PhaseCode,
    override val unitMultiplier: UnitMultiplier,
    override val unitSymbol: UnitSymbol,
    override val terminal: ACDCTerminal?,
    override val powerSystemResource: PowerSystemResource?,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : Measurement

/** Слой, на котором отображаются элементы схемы */
class VisibilityLayer(
    /** Порядковый номер слоя схемы при отрисовке */
    val drawingOrder: Int,
    /** Элементы схемы, которые отображены на слое схемы */
    val visibleObjects: Array<DiagramObject>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Аварийное событие, вызывающее возмущение в энергосистеме. Под аварийным событием понимается не только замыкание, а любое возмущение в энергосистеме (качание, асинхронный ход, замыкание и т.д.). Тип этого возмущения указывается с помощью класса rf:FaultType */
open class Fault(
    /** Дата и время возникновения аварийного события */
    val occurredDateTime: LocalDateTime,
    /** Тип аварийного события */
    val rf_type: rf_FaultType,
    /** Вид повреждения фаз */
    val kind: PhaseConnectedFaultKind,
    /** Фазы ЛЭП или оборудования, поврежденные при наступлении аварийного события */
    val phases: PhaseCode,
    /** Поврежденное при наступлении аварийного события оборудование */
    val faultyEquipment: Equipment?,
    /** Отклонение от нормального режима ЭЭС, вызванное аварийным событием */
    val outage: Outage?,
    /** События срабатывания/пуска РЗА, вызванные наступлением аварийного события */
    val rf_OperationEvents: Array<rf_PACSOperationEvent>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Набор значений, полученных с прибора учета */
class MeterReading(
    /** Дата и временной интервал элементов данных, содержащихся в показании прибора учета */
    val valuesInterval: DateTimeInterval,
    /** События конечного устройства, связанные с набором показаний прибора учета */
    val endDeviceEvents: Array<EndDeviceEvent>,
    /** Интервальные блоки, содержащиеся в показании прибора учета */
    val intervalBlocks: Array<IntervalBlock>,
    /** Прибор учета, с которого получено показание */
    val meter: Meter?,
    /** Показания, содержащиеся в показании прибора учета */
    val readings: Array<Reading>,
    /** Точка поставки, из которой были получены показания прибора учета (набор значений) */
    val usagePoint: UsagePoint?,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Тип кодов качества ICCP */
class ICCPQualityKind(
    /** Декларирует для точки ICCP отсутствие атрибута качества передаваемого значения */
    val none: Any,
    /** Декларирует наличие только атрибута качества при передаче значения */
    val qualityOnly: Any,
    /** Декларирует наличие атрибутов качества и метки времени при передаче значения */
    val qualityAndTime: Any,
    /** Декларирует наличие только дополнительной информации при передаче значения */
    val extended: Any,
    /** Декларирует наличие атрибутов качества, метки времени и дополнительной информации при передаче значения */
    val extendedwithQualityTime: Any
)

/** Электронный адрес */
class ElectronicAddress(
    /** Почтовый адрес 1 */
    val email1: String,
    /** Почтовый адрес 2 */
    val email2: String,
    /** Адрес сети */
    val lan: String,
    /** MAC (Media Access Control) адрес */
    val mac: String,
    /** Пароль */
    val password: String,
    /** Радиоадрес */
    val radio: String,
    /** Идентификатор */
    val userID: String,
    /** Интернет адрес */
    val web: String
)