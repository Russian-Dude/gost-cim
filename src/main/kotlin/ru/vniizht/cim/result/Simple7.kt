import ru.vniizht.model.result.ActivePower
import ru.vniizht.model.result.RealEnergy
import ru.vniizht.model.result.Seconds
import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Технические параметры проводников многофазного кабеля/ЛЭП */
class WireAssemblyInfo(
    /** Удельные параметры ЛЭП, рассчитанные на основании WireAssemblyInfo */
    val perLengthLineParameter: Array<PerLengthLineParameter>,
    /** Информация о фазах многожильного проводника */
    val wirePhaseInfo: Array<WirePhaseInfo>,
    override val productAssetModel: ProductAssetModel?,
    override val assets: Array<Asset>,
    override val powerSystemResources: Array<PowerSystemResource>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : AssetInfo

/** Стандартное номинальное напряжение */
class BaseVoltage(
    /** Признак того, что значение номинального напряжения является напряжением постоянного тока */
    val rf_isDC: Boolean,
    /** Значение номинального напряжения, кВ */
    val nominalVoltage: Double,
    /** Электропроводящее оборудование, относящееся к стандартному номинальному напряжению */
    val conductingEquipment: Array<ConductingEquipment>,
    /** Вводы трансформатора, относящиеся к стандартному номинальному напряжению */
    val transformerEnds: Array<TransformerEnd>,
    /** Распределительные устройства, относящиеся к стандартному номинальному напряжению */
    val voltageLevel: Array<VoltageLevel>,
    /** Материальные объекты, внедряемые на номинальном напряжении */
    val networkAssetDeployment: Array<AssetDeployment>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Конструктивные фазные параметры проводника */
class WireSpacingInfo(
    /** Проводник является кабелем (если присвоено значение "Истина") */
    val isCable: Boolean,
    /** Количество проводников в симметричном пучке */
    val phaseWireCount: Int,
    /** Расстояние между проводниками в симметричном пучке, м */
    val phaseWireSpacing: Double,
    /** Конструктивные элементы линии переменного тока, к которым относится информация о расщеплении проводников */
    val structures: Array<Structure>,
    /** Положение одиночных проводов (фазных или нейтральных) */
    val wirePositions: Array<WirePosition>,
    override val productAssetModel: ProductAssetModel?,
    override val assets: Array<Asset>,
    override val powerSystemResources: Array<PowerSystemResource>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : AssetInfo

/** Почтовый адрес */
class StreetAddress(
    /** Почтовый индекс */
    val postalCode: String,
    /** Адрес в населенном пункте или городе */
    val streetDetail: StreetDetail,
    /** Расположение города и район */
    val townDetail: TownDetail
)

/** Данные многофункциональной кривой */
class CurveData(
    /** Значение по оси X */
    val xvalue: Double,
    /** Значение по оси Y1 */
    val y1value: Double,
    /** Значение по оси Y2 */
    val y2value: Double,
    /** Значение по оси Y3 */
    val y3value: Double,
    /** Многофункциональная кривая, к которой относится параметр кривой */
    val curve: Curve
)

/** Категория услуги, предоставляемой заказчику */
class ServiceCategory(
    /** Вид услуги */
    val kind: ServiceKind,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Интервал времени */
class TimeInterval(
    /** Время окончания интервала */
    val end: LocalDateTime,
    /** Время начала интервала */
    val start: LocalDateTime
)

/** Подробная информация о функции удаленного подключения и отключения */
class RemoteConnectDisconnectInfo(
    /** Настройка тайм-аута истекшего времени */
    val armedTimeout: Seconds,
    /** Предел напряжения на стороне потребителя выключателя, выше которого подключение не должно выполняться */
    val customerВещественныйLimit: Double,
    /** Лимит энергии перед отключением */
    val energyLimit: RealEnergy,
    /** Дата начала и время накопления энергии для ограничения энергопотребления */
    val energyUsageStartDateTime: LocalDateTime,
    /** Предупреждение об ограничении энергии, используемое для запуска кода события, что потребление энергии приближается к пределу */
    val energyUsageWarning: RealEnergy,
    /** TRUE, если переключатель должен быть включен до начала действия подключения */
    val isArmConnect: Boolean,
    /** TRUE, если переключатель должен быть включен до начала действия отключения */
    val isArmDisconnect: Boolean,
    /** TRUE, если потребление энергии ограничено, и клиент будет отключен, если он превысит лимит */
    val isEnergyLimiting: Boolean,
    /** TRUE, если необходимо проверить предел нагрузки для немедленного отключения (после подключения), если нагрузка превышает предел */
    val needsPowerLimitCheck: Boolean,
    /** TRUE, если предел напряжения должен быть проверен, чтобы предотвратить подключение, если напряжение превышает предел */
    val needsВещественныйLimitCheck: Boolean,
    /** Лимит мощности, выше которого подключение либо не должно происходить, либо должно привести к немедленному отключению */
    val powerLimit: ActivePower,
    /** TRUE, если для подключения необходимо использовать кнопку */
    val usePushbutton: Boolean
)

/** Подробное описание команды управления, выполняемого конечным устройством */
class EndDeviceControlType(
    /** Высокоуровневая предметная область элемента управления */
    val domain: String,
    /** Наиболее специфическая часть типа элемента управления */
    val eventOrAction: String,
    /** Более специфическая предметная область элемента управления, как подвариант domain */
    val subDomain: String,
    /** Тип физического устройства, из которого был создан элемент управления */
    val type: String,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Строка таблицы фазосдвигающего переключателя регулировочных ответвлений обмотки трансформатора */
class PhaseTapChangerTablePoint(
    /** Разница углов, град */
    val angle: Double,
    /** Таблица фазосдвигающего переключателя регулировочных ответвлений обмотки трансформатора, к которой относится строка таблицы */
    val phaseTapChangerTable: PhaseTapChangerTable?,
    b: Double,
    g: Double,
    r: Double,
    ratio: Double,
    step: Int,
    x: Double
) : TapChangerTablePoint(
    b = b,
    g = g,
    r = r,
    ratio = ratio,
    step = step,
    x = x
)