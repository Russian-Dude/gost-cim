import ru.vniizht.model.result.CurrentFlow
import ru.vniizht.model.result.PerCent
import ru.vniizht.model.result.UserAttribute
import ru.vniizht.model.result.Voltage
import java.time.LocalDateTime
import java.util.*

/** Общие технические параметры коммутационных аппаратов */
open class SwitchInfo(
    /** Номинальный ток отключения коммутационного аппарата, А */
    val breakingCapacity: Double,
    /** Номинальный ток, А */
    val ratedCurrent: Double,
    /** Собственное время отключения, с */
    val ratedInterruptingTime: Double,
    /** Собственное время включения, с */
    val rf_ratedInTransitTime: Double,
    /** Номинальное напряжение, кВ */
    val ratedVoltage: Double,
    /** Если присвоено значение "Истина", выключатель имеет пофазное исполнение */
    val isSinglePhase: Boolean,
    /** Если присвоено значение "Истина", привод управления фазой независимый */
    val isUnganged: Boolean,
    /** Если присвоено значение "Истина", есть возможность независимого управления фазой */
    val rf_isUngangedControl: Boolean,
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

/** Событие, обнаруженное функцией устройства, связанной с конечным устройством */
class EndDeviceEvent(
    /** Подробности события конечного устройства */
    val endDeviceEventDetails: Array<EndDeviceEventDetail>,
    /** Тип события конечного устройства */
    val endDeviceEventType: EndDeviceEventType?,
    /** Точка поставки, для которой сообщается о событии конечного устройства */
    val usagePoint: UsagePoint?,
    createdDateTime: LocalDateTime,
    reason: String,
    severity: String,
    status: Status,
    type: String,
    assets: Array<Asset>,
    aliasName: String,
    description: String,
    mRID: UUID,
    name: String,
    names: Array<Name>,
    rf_OrganisationRoles: Array<OrganisationRole>,
    rf_CustomAttributes: Array<UserAttribute>,
    diagramObjects: Array<DiagramObject>
) : ActivityRecord(
    createdDateTime = createdDateTime,
    reason = reason,
    severity = severity,
    status = status,
    type = type,
    assets = assets,
    aliasName = aliasName,
    description = description,
    mRID = mRID,
    name = name,
    names = names,
    rf_OrganisationRoles = rf_OrganisationRoles,
    rf_CustomAttributes = rf_CustomAttributes,
    diagramObjects = diagramObjects
)

/** Составная часть схемы замещения трансформатора типа полного многоугольника */
class TransformerMeshImpedance(
    /** Активное сопротивление прямой последовательности, Ом */
    val r: Double,
    /** Активное сопротивление нулевой последовательности, Ом */
    val r0: Double,
    /** Реактивное сопротивление прямой последовательности, Ом */
    val x: Double,
    /** Реактивное сопротивление нулевой последовательности, Ом */
    val x0: Double,
    /** Вывод трансформатора "из", с которым связан TransformerMeshImpedance */
    val fromTransformerEnd: TransformerEnd?,
    /** Вывод трансформатора "в", с которым связан TransformerMeshImpedance */
    val toTransformerEnd: Array<TransformerEnd>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Технические параметры устройств продольной компенсации */
open class rf_SeriesCompensatorInfo(
    /** Потери активной мощности при номинальном напряжении, кВт */
    val loss: Double,
    /** Наибольшее рабочее напряжение, кВ */
    val maxVoltage: Double,
    /** Номинальный ток, А */
    val ratedCurrent: Double,
    /** Номинальная реактивная мощность, Мвар */
    val ratedReactivePower: Double,
    /** Номинальное напряжение, кВ */
    val ratedVoltage: Double,
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

/** Схема */
class Diagram(
    /** Ориентация координатной плоскости схемы */
    val orientation: OrientationKind,
    /** Координата начала схемы по оси X */
    val x1InitialView: Double,
    /** Координата конца схемы по оси X */
    val x2InitialView: Double,
    /** Координата начала схемы по оси Y */
    val y1InitialView: Double,
    /** Координата конца схемы по оси Y */
    val y2InitialView: Double,
    /** Совокупность элементов схемы */
    val diagramElements: Array<DiagramObject>,
    /** Стиль, в соответствии с которым отображена схема */
    val diagramStyle: DiagramStyle?,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Органическое топливо */
class FossilFuel(
    /** Вид органического топлива */
    val fossilFuelType: FuelType,
    /** КПД на данном типе топлива, о.е. */
    val fuelEffFactor: Double,
    /** Количество теплоты на единицу веса или объема для данного вида топлива */
    val fuelHeatContent: Double,
    /** Тепловой энергоблок, использующий данный вид топлива */
    val thermalGeneratingUnit: ThermalGeneratingUnit,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Технические параметры шунтирующих компенсирующих устройств */
open class ShuntCompensatorInfo(
    /** Потери активной мощности ШР при номинальном напряжении, кВт */
    val loss: Double,
    /** Максимальные потери полной мощности, МВА */
    val maxPowerLoss: Double,
    /** Номинальная реактивная мощность, Мвар */
    val ratedReactivePower: Double,
    /** Номинальный ток, А */
    val ratedCurrent: Double,
    /** Номинальное напряжение, кВ */
    val ratedVoltage: Double,
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

/** Материальный объект */
open class Asset(
    /** Объекты энергосистемы, ассоциированные с материальным объектом */
    val powerSystemResources: Array<PowerSystemResource>,
    /** Материальный объект, включающий в себя текущий материальный объект */
    val assetContainer: AssetContainer?,
    /** Расположение материального объекта */
    val location: Location?,
    /** Даты этапов ввода в эксплуатацию. Структурный класс данных профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением Б */
    val inUseDate: InUseDate,
    /** Виды состояний ввода в эксплуатацию. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val inUseState: InUseStateKind,
    /** Даты этапов жизненного цикла актива/материального объекта. Структурный класс данных профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением Б */
    val lifecycleDate: LifecycleDate,
    /** Положение материального объекта (обычно в отношении других материальных объектов) */
    val position: String,
    /** Тип материального объекта */
    val type: String,
    /** Техническая информация о материальном объекте */
    val assetInfo: AssetInfo?,
    /** Информация о внедрении материального объекта */
    val assetDeployment: AssetDeployment?,
    /** Организационные роли материального объекта */
    val assetOrganisationRoles: Array<AssetOrganisationRole>,
    /** Модель материального объекта */
    val productAssetModel: ProductAssetModel?,
    /** Состояние материального объекта на складе или во время установки */
    val baselineCondition: String,
    /** Процент ожидаемого срока службы нового материального объекта, когда материальный объект восстанавливается; ноль для новых устройств [Проценты] */
    val baselineLossOfLife: PerCent,
    /** Электронный адрес устройства */
    val electronicAddress: ElectronicAddress,
    /** Номер партии устройства */
    val lotNumber: String,
    /** Серийный номер устройства */
    val serialNumber: String,
    /** Состояние */
    val status: String,
    /** Уникально отслеживаемый товарный номер (UTC) */
    val utcNumber: String,
    /** Записи активности материального объекта */
    val activityRecords: Array<ActivityRecord>,
    /** События конфигурирования материального объекта */
    val configurationEvents: Array<ConfigurationEvent>,
    /** Набор параметров НТИ, которая может быть сгенерирована МП РЗА, представленным данным материальным объектом */
    val pEData: Array<rf_ProtectionEquipmentData>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Электрические параметры магнитопровода трансформатора */
class TransformerCoreAdmittance(
    /** Реактивная проводимость прямой последовательности шунта намагничивания, приведенная к номинальному напряжению вывода с наивысшим напряжением, См */
    val b: Double,
    /** Реактивная проводимость нулевой последовательности шунта намагничивания, приведенная к номинальному напряжению вывода с наивысшим напряжением, См */
    val b0: Double,
    /** Схема соединения обмоток. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val rf_connectionKind: WindingConnection,
    /** Активная проводимость прямой последовательности шунта намагничивания, приведенная к номинальному напряжению вывода с наивысшим напряжением, См */
    val g: Double,
    /** Выводы трансформатора, с которыми связаны электрические параметры магнитопровода трансформатора */
    val transformerEnd: Array<TransformerEnd>,
    /** Технические параметры вывода трансформатора, с которыми связаны электрические параметры магнитопровода трансформатора */
    val transformerEndInfo: TransformerEndInfo?,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Свойства ТТ */
class CurrentTransformerInfo(
    /** Количество сердечников обмоток */
    val coreCount: Int,
    /** Класс ТТ */
    val ctClass: String,
    /** Максимальный первичный ток, А, равный 120% от номинального */
    val kneePointCurrent: CurrentFlow,
    /** Напряжение на вторичной обмотке ТТ, В, при котором достигается максимальное значение нагрузки */
    val kneePointVoltage: Voltage,
    /** Максимальное значение коэффициента трансформации */
    val maxRatio: Ratio,
    /** Номинальное значение коэффициента трансформации */
    val nominalRatio: Ratio,
    /** Полная вторичная нагрузка для первичной обмотки, А */
    val primaryFlsRating: CurrentFlow,
    /** Номинальное значение обмотки высшего напряжения */
    val primaryRatio: Ratio,
    /** Номинальный ток на первичной стороне, А */
    val ratedCurrent: CurrentFlow,
    /** Полная вторичная нагрузка для вторичной обмотки, А */
    val secondaryFlsRating: CurrentFlow,
    /** Номинальное значение обмотки среднего напряжения */
    val secondaryRatio: Ratio,
    /** Полная вторичная нагрузка для третичной обмотки, А */
    val tertiaryFlsRating: CurrentFlow,
    /** Номинальное значение обмотки низшего напряжения. Значение тока третичной обмотки, А, по высокой стороне */
    val tertiaryRatio: Ratio,
    /** Использование: например, измерение, защита и т.д. */
    val usage: String,
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