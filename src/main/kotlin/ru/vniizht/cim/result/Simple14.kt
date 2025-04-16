import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Подробное описание события, произведенного конечным устройством */
class EndDeviceEventType(
    /** Высокоуровневая предметная область события */
    val domain: String,
    /** Наиболее специфическая часть события */
    val eventOrAction: String,
    /** Более специфическая предметная область события */
    val subDomain: String,
    /** Тип физического устройства, из которого было создано событие */
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

/** Файл с результатами ОМП на линии электропередачи */
class rf_FaultLocationDocument(
    /** Набор параметров файла ОМП */
    val faultLocationData: rf_FaultLocationData,
    createdDateTime: LocalDateTime,
    electronicAddress: ElectronicAddress,
    lastModifiedDateTime: LocalDateTime,
    configurationEvents: Array<ConfigurationEvent>,
    aliasName: String,
    description: String,
    mRID: UUID,
    name: String,
    names: Array<Name>,
    rf_OrganisationRoles: Array<OrganisationRole>,
    rf_CustomAttributes: Array<UserAttribute>,
    diagramObjects: Array<DiagramObject>
) : Document(
    createdDateTime = createdDateTime,
    electronicAddress = electronicAddress,
    lastModifiedDateTime = lastModifiedDateTime,
    configurationEvents = configurationEvents,
    aliasName = aliasName,
    description = description,
    mRID = mRID,
    name = name,
    names = names,
    rf_OrganisationRoles = rf_OrganisationRoles,
    rf_CustomAttributes = rf_CustomAttributes,
    diagramObjects = diagramObjects
)

/** Тип объекта энергосистемы */
class PSRType(
    /** Энергообъекты с дополнительным классификатором */
    val powerSystemResources: Array<PowerSystemResource>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Модель оборудования определенного производителя */
class ProductAssetModel(
    /** Срок службы материального объекта, установленный заводом-изготовителем, лет */
    val rf_guaranteedServiceLife: Int,
    /** Материальные объекты, соответствующие определенной модели оборудования */
    val asset: Array<Asset>,
    /** Технические параметры модели оборудования */
    val assetInfo: AssetInfo?,
    /** Производитель определенной модели оборудования */
    val manufacturer: Manufacturer?,
    /** Вид корпоративного стандарта модели материального объекта */
    val corporateStandardKind: CorporateStandardKind,
    /** Номер модели производителя */
    val modelNumber: String,
    /** Номер версии модели продукта, указывающий на год выпуска продукта */
    val modelVersion: String,
    /** Предполагаемое использование для модели материального объекта */
    val usageKind: AssetModelUsageKind,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Вторичная обмотка измерительного трансформатора */
open class rf_SensorWinding(
    /** Функции РЗА, которые относятся к обмотке трансформатора тока или напряжения */
    val rf_ProtectionEquipment: Array<ProtectionEquipment>,
    /** Класс точности */
    val accuracyClass: String,
    /** Схема соединения обмоток. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val connectionKind: WindingConnection,
    /** Номинальная полная мощность, МВА */
    val ratedS: Double,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Вторичная обмотка трансформатора напряжения */
class rf_PotentialTransformerWinding(
    /** Коэффициент преобразования, о.е. */
    val nominalRatio: Double,
    /** Номинальное напряжение, кВ */
    val nominalVoltage: Double,
    /** Напряжение короткого замыкания, % */
    val shortCircuitVoltage: Double,
    /** Трансформатор напряжения, к которому относится обмотка */
    val rf_Transformer: PotentialTransformer,
    rf_ProtectionEquipment: Array<ProtectionEquipment>,
    accuracyClass: String,
    connectionKind: WindingConnection,
    ratedS: Double,
    aliasName: String,
    description: String,
    mRID: UUID,
    name: String,
    names: Array<Name>,
    rf_OrganisationRoles: Array<OrganisationRole>,
    rf_CustomAttributes: Array<UserAttribute>,
    diagramObjects: Array<DiagramObject>
) : rf_SensorWinding(
    rf_ProtectionEquipment = rf_ProtectionEquipment,
    accuracyClass = accuracyClass,
    connectionKind = connectionKind,
    ratedS = ratedS,
    aliasName = aliasName,
    description = description,
    mRID = mRID,
    name = name,
    names = names,
    rf_OrganisationRoles = rf_OrganisationRoles,
    rf_CustomAttributes = rf_CustomAttributes,
    diagramObjects = diagramObjects
)

/** Таблица зависимости эксплуатационных ограничений/пределов от температуры */
class TemperatureDependentLimitTable(
    /** Строка таблицы зависимости эксплуатационных ограничений/пределов от температуры */
    val temperatureLimitTablePoint: Array<TemperatureDependentLimitPoint>,
    override val equipment: Equipment?,
    override val operationalLimit: Array<OperationalLimit>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : EnvironmentalDependentLimit

/** Технические параметры оборудования защиты от перенапряжения */
class SurgeArresterInfo(
    /** Номинальный разрядный ток, А */
    val nominalDischargeCurrent: Double,
    /** Номинальное напряжение разрядника, В */
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

/** Технические параметры синхронной машины */
class rf_SynchronousMachineInfo(
    /** Допустимая продолжительность работы в асинхронном режиме, с */
    val asyncModeAllowedTime: Double,
    /** Суммарный маховый момент элементов, расположенных на одном валу с генератором (в том числе возбудитель, компрессор), не включая маховый момент турбины, т·м2 */
    val generatorGD2: Double,
    /** Допускается работа в асинхронном режиме (если присвоено значение "Истина") */
    val isAsyncModeAdmissibility: Boolean,
    /** Ток возбуждения в режиме максимальной нагрузки (при номинальных значениях (U, f, ), А */
    val maxLoadExcCurrent: Double,
    /** Напряжение возбуждения в режиме максимальной нагрузки (при номинальных значениях U, f, ), В */
    val maxLoadExcVoltage: Double,
    /** Ток возбуждения в режиме холостого хода, А */
    val noLoadExcCurrent: Double,
    /** Напряжение возбуждения в режиме холостого хода, кВ */
    val noLoadExcVoltage: Double,
    /** Номинальная частота вращения, об/с */
    val nominalRotationSpeed: Double,
    /** Ток возбуждения в режиме номинальной нагрузки (при номинальных значениях U, f, ), А */
    val ratedExcCurrent: Double,
    /** Напряжение возбуждения в режиме номинальной нагрузки (при номинальных значениях U, f, ), В */
    val ratedExcVoltage: Double,
    /** Ток возбуждения при коротком замыкании, А */
    val shortCircuitExcCurrent: Double,
    override val rotorGD2: Double,
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
) : rf_RotatingMachineInfo

/** Общие технические параметры конструкции трансформатора */
class TransformerTankInfo(
    /** Тип системы охлаждения. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val rf_coolingKind: CoolingKind,
    /** Информация о технических параметрах выводов трансформатора */
    val transformerEndInfos: Array<TransformerEndInfo>,
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