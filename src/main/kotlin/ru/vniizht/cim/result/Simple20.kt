import ru.vniizht.model.result.PerCent
import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Ошиновка */
class rf_BusArrangement(
    override val terminal: Terminal,
    override val faults: Array<Fault>,
    override val outages: Array<Outage>,
    override val normallyInService: Boolean,
    override val equipmentContainer: EquipmentContainer?,
    override val additionalEquipmentContainer: Array<EquipmentContainer>,
    override val usagePoints: Array<UsagePoint>,
    override val limitDependencyModel: Array<LimitDependency>,
    override val operationalLimitSet: Array<OperationalLimitSet>,
    override val rf_VoltageLimitDurationCurve: rf_VoltageLimitDurationCurve?,
    override val assets: Array<Asset>,
    override val pSRType: PSRType?,
    override val measurements: Array<Measurement>,
    override val location: Location?,
    override val assetDatasheet: AssetInfo?,
    override val controls: Array<Control>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : AuxiliaryEquipment

/** Описание всего, что меняется с течением времени */
class TimeSchedule(
    /** Расписание */
    val scheduleInterval: DateTimeInterval,
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

/** Кипящий водо-водяной реактор */
class BWRSteamSupply(
    override val steamTurbines: Array<SteamTurbine>,
    override val assets: Array<Asset>,
    override val pSRType: PSRType?,
    override val measurements: Array<Measurement>,
    override val location: Location?,
    override val assetDatasheet: AssetInfo?,
    override val controls: Array<Control>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : SteamSupply

/** Полюс электропроводящего оборудования. Элемент модели для обозначения электрического подключения к электропроводящему оборудованию */
class Terminal(
    /** Вспомогательное оборудование, подключенное к полюсу электропроводящего оборудования */
    val auxiliaryEquipment: Array<AuxiliaryEquipment>,
    /** Электропроводящее оборудование, к которому принадлежит полюс */
    val conductingEquipment: ConductingEquipment,
    /** Соединительный узел полюсов */
    val connectivityNode: ConnectivityNode?,
    /** (агрегирование)
    Выводы трансформатора, к которым подключен полюс */
    val transformerEnd: Array<TransformerEnd>,
    /** Код фазы терминала. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val phases: PhaseCode,
    /** Сегменты участка линии переменного тока, нумеруемые относительно полюса */
    val rf_ACLineSeriesSection: Array<rf_ACLineSeriesSection>,
    /** Электромагнитные связи с участками линии переменного тока, каждый из которых объявлен первым в паре взаимосвязанных */
    val hasFirstMutualCoupling: Array<MutualCoupling>,
    /** Электромагнитные связи с участками линии переменного тока, каждый из которых объявлен вторым в паре взаимосвязанных */
    val hasSecondMutualCoupling: Array<MutualCoupling>,
    /** Полюс оборудования, ассоциированный с системой автоматического регулирования */
    val regulatingControl: Array<RegulatingControl>,
    /** Питающая линия, которая в нормальной схеме питается от данного полюса электропроводящего оборудования. Указывается только для полюсов головного участка питающей линии */
    val normalHeadFeeder: Feeder?,
    override val sequenceNumber: Int,
    override val measurements: Array<Measurement>,
    override val operationalLimitSet: Array<OperationalLimitSet>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : ACDCTerminal

/** Котел сверхкритического давления */
class Supercritical(
    override val steamTurbines: Array<SteamTurbine>,
    override val assets: Array<Asset>,
    override val pSRType: PSRType?,
    override val measurements: Array<Measurement>,
    override val location: Location?,
    override val assetDatasheet: AssetInfo?,
    override val controls: Array<Control>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : FossilSteamSupply

/** Производственный объект, содержащий другие производственные объекты (строения, коммутирующие, генерирующие устройства, обслуживаемые устройства) */
class Facility(
    assets: Array<Asset>,
    seals: Array<Seal>,
    powerSystemResources: Array<PowerSystemResource>,
    assetContainer: AssetContainer?,
    location: Location?,
    inUseDate: InUseDate,
    inUseState: InUseStateKind,
    lifecycleDate: LifecycleDate,
    position: String,
    type: String,
    assetInfo: AssetInfo?,
    assetDeployment: AssetDeployment?,
    assetOrganisationRoles: Array<AssetOrganisationRole>,
    productAssetModel: ProductAssetModel?,
    baselineCondition: String,
    baselineLossOfLife: PerCent,
    electronicAddress: ElectronicAddress,
    lotNumber: String,
    serialNumber: String,
    status: String,
    utcNumber: String,
    activityRecords: Array<ActivityRecord>,
    configurationEvents: Array<ConfigurationEvent>,
    pEData: Array<rf_ProtectionEquipmentData>,
    aliasName: String,
    description: String,
    mRID: UUID,
    name: String,
    names: Array<Name>,
    rf_OrganisationRoles: Array<OrganisationRole>,
    rf_CustomAttributes: Array<UserAttribute>,
    diagramObjects: Array<DiagramObject>
) : AssetContainer(
    assets = assets,
    seals = seals,
    powerSystemResources = powerSystemResources,
    assetContainer = assetContainer,
    location = location,
    inUseDate = inUseDate,
    inUseState = inUseState,
    lifecycleDate = lifecycleDate,
    position = position,
    type = type,
    assetInfo = assetInfo,
    assetDeployment = assetDeployment,
    assetOrganisationRoles = assetOrganisationRoles,
    productAssetModel = productAssetModel,
    baselineCondition = baselineCondition,
    baselineLossOfLife = baselineLossOfLife,
    electronicAddress = electronicAddress,
    lotNumber = lotNumber,
    serialNumber = serialNumber,
    status = status,
    utcNumber = utcNumber,
    activityRecords = activityRecords,
    configurationEvents = configurationEvents,
    pEData = pEData,
    aliasName = aliasName,
    description = description,
    mRID = mRID,
    name = name,
    names = names,
    rf_OrganisationRoles = rf_OrganisationRoles,
    rf_CustomAttributes = rf_CustomAttributes,
    diagramObjects = diagramObjects
)

/** Некоторое значение, вычисленное прибором учета или другим материальным объектом либо рассчитанное системой */
class Reading(
    /** Причина, по которой показание было получено */
    val reason: ReadingReasonKind,
    /** Тип значения */
    val readingType: ReadingType?,
    override val firstReportedDateTime: LocalDateTime,
    override val source: String,
    override val timePeriod: DateTimeInterval,
    override val value: String,
    override val readingQualities: Array<ReadingQuality>,
    override val analogValue: Any,
    override val discreteValue: Any,
    override val timeStamp: LocalDateTime,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : BaseReading

/** Файл осциллограммы */
class rf_OscillogramDocument(
    /** День, месяц и год, час, минута и секунда первого значения данных (первой выборки), содержащихся в файле данных РАС */
    val firstValueTimestamp: LocalDateTime,
    /** День, месяц и год, час, минута и секунда первого пуска записи осциллограммы */
    val triggerPointTimestamp: LocalDateTime,
    /** Набор параметров осциллограммы для данного файла осциллограммы */
    val oscillogram: rf_Oscillogram,
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

/** Параметры конструкции подземной ЛЭП */
class UndergroundStructure(
    /** Тип конструкции КЛ. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val kind: UndergroundStructureKind,
    /** Основной материал конструкции КЛ */
    val material: String,
    ratedVoltage: Double,
    rf_rEarth: Double,
    wireSpacingInfos: Array<WireSpacingInfo>,
    assets: Array<Asset>,
    seals: Array<Seal>,
    powerSystemResources: Array<PowerSystemResource>,
    assetContainer: AssetContainer?,
    location: Location?,
    inUseDate: InUseDate,
    inUseState: InUseStateKind,
    lifecycleDate: LifecycleDate,
    position: String,
    type: String,
    assetInfo: AssetInfo?,
    assetDeployment: AssetDeployment?,
    assetOrganisationRoles: Array<AssetOrganisationRole>,
    productAssetModel: ProductAssetModel?,
    baselineCondition: String,
    baselineLossOfLife: PerCent,
    electronicAddress: ElectronicAddress,
    lotNumber: String,
    serialNumber: String,
    status: String,
    utcNumber: String,
    activityRecords: Array<ActivityRecord>,
    configurationEvents: Array<ConfigurationEvent>,
    pEData: Array<rf_ProtectionEquipmentData>,
    aliasName: String,
    description: String,
    mRID: UUID,
    name: String,
    names: Array<Name>,
    rf_OrganisationRoles: Array<OrganisationRole>,
    rf_CustomAttributes: Array<UserAttribute>,
    diagramObjects: Array<DiagramObject>
) : Structure(
    ratedVoltage = ratedVoltage,
    rf_rEarth = rf_rEarth,
    wireSpacingInfos = wireSpacingInfos,
    assets = assets,
    seals = seals,
    powerSystemResources = powerSystemResources,
    assetContainer = assetContainer,
    location = location,
    inUseDate = inUseDate,
    inUseState = inUseState,
    lifecycleDate = lifecycleDate,
    position = position,
    type = type,
    assetInfo = assetInfo,
    assetDeployment = assetDeployment,
    assetOrganisationRoles = assetOrganisationRoles,
    productAssetModel = productAssetModel,
    baselineCondition = baselineCondition,
    baselineLossOfLife = baselineLossOfLife,
    electronicAddress = electronicAddress,
    lotNumber = lotNumber,
    serialNumber = serialNumber,
    status = status,
    utcNumber = utcNumber,
    activityRecords = activityRecords,
    configurationEvents = configurationEvents,
    pEData = pEData,
    aliasName = aliasName,
    description = description,
    mRID = mRID,
    name = name,
    names = names,
    rf_OrganisationRoles = rf_OrganisationRoles,
    rf_CustomAttributes = rf_CustomAttributes,
    diagramObjects = diagramObjects
)

/** Фазосдвигающий переключатель. Фазосдвигающий переключатель регулировочных ответвлений обмотки трансформатора (табличное представление зависимости) */
class PhaseTapChangerTabular(
    /** Таблица фазосдвигающего переключателя регулировочных ответвлений обмотки трансформатора */
    val phaseTapChangerTable: PhaseTapChangerTable?,
    override val transformerEnd: TransformerEnd?,
    override val controlEnabled: Boolean,
    override val highStep: Int,
    override val lowStep: Int,
    override val itcFlag: Boolean,
    override val neutralStep: Int,
    override val rf_neutralStepCount: Int,
    override val normalStep: Int,
    override val tapChangerControl: TapChangerControl?,
    override val assets: Array<Asset>,
    override val pSRType: PSRType?,
    override val measurements: Array<Measurement>,
    override val location: Location?,
    override val assetDatasheet: AssetInfo?,
    override val controls: Array<Control>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : PhaseTapChanger