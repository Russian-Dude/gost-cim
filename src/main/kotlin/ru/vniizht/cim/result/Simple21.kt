import ru.vniizht.model.result.PerCent
import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Документ, описывающий обстоятельства существующего или планируемого отключения в электрической сети */
class Outage(
    /** Период отклонения от нормального режима */
    val actualPeriod: DateTimeInterval,
    /** Аварийные события, произошедшие при данном отклонении от нормального режима ЭЭС */
    val faults: Array<Fault>,
    /** Оборудование, связанное с аварийным событием */
    val equipments: Array<Equipment>,
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

/** Тепловой энергоблок */
class ThermalGeneratingUnit(
    /** Параметры парового энергоблока в составе парогазовой установки при различном составе газотурбинных установок */
    val rf_CapacityConfiguration: Array<rf_CapacityConfiguration>,
    /** Группа генерирующих установок, предназначенных для выработки электроэнергии и технологического пара */
    val cogenerationPlant: CogenerationPlant?,
    /** Группа генерирующих установок с комбинированным циклом */
    val combinedCyclePlant: CombinedCyclePlant?,
    /** Виды топлива, используемые тепловым энергоблоком */
    val fossilFuels: Array<FossilFuel>,
    override val rotatingMachine: RotatingMachine?,
    override val governorSCD: Double,
    override val highControlLimit: Double,
    override val lowControlLimit: Double,
    override val lowerRampRate: Double,
    override val maxOperatingP: Double,
    override val minOperatingP: Double,
    override val nominalP: Double,
    override val raiseRampRate: Double,
    override val rf_unitGD2: Double,
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
) : GeneratingUnit

/** Параметры опыта короткого замыкания обмотки трансформатора */
class ShortCircuitTest(
    /** Потери короткого замыкания, кВт */
    val loss: Double,
    /** Напряжение короткого замыкания, % */
    val voltage: Double,
    /** Положение переключателя ответвлений для обмотки под напряжением */
    val energizedEndStep: Int,
    /** Положение переключателя ответвлений для заземленной обмотки */
    val groundedEndStep: Int,
    /** Вывод трансформатора, к которому относятся данные опыта короткого замыкания */
    val energisedEnd: TransformerEndInfo?,
    /** Заземленные выводы трансформатора в опыте короткого замыкания */
    val groundedEnds: Array<TransformerEndInfo>,
    override val basePower: Double,
    override val temperature: Double,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : TransformerTest

/** ВЧ заградитель */
class WaveTrap(
    /** Номинальный ток высокочастотного заградителя, А */
    val rf_ratedCurrent: Double,
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

/** Питающая линия - контейнер оборудования, соединяющего распределительное устройство питающей подстанции с одним или несколькими распределительными устройствами, либо потребителями */
class Feeder(
    /** Подстанции, на которые по нормальной схеме подается напряжение через питающую линию */
    val normalEnergizedSubstation: Array<Substation>,
    /** Полюс или полюсы электропроводящего оборудования, являющиеся концами головного участка питающей линии */
    val normalHeadTerminal: Array<Terminal>,
    /** Подстанция, подающая напряжение на питающую линию по нормальной схеме */
    val normalEnergizingSubstation: Substation?,
    override val equipments: Array<Equipment>,
    override val additionalGroupedEquipment: Array<Equipment>,
    override val connectivityNodes: Array<ConnectivityNode>,
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
) : EquipmentContainer

/** Опора ЛЭП */
class Tower(
    /** Конструкция опоры ЛЭП. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val constructionKind: TowerConstructionKind,
    /** Режим заземления грозотросов */
    val rf_groundingMode: String,
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

/** Барабанный котел */
class DrumBoiler(
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

/** Данные, полученные через регулярные промежутки времени */
class IntervalReading(
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

/** Удельные электрические параметры фазы участка ЛЭП */
class PerLengthPhaseImpedance(
    /** Ограничение количества элементов матрицы фазных удельных параметров */
    val conductorCount: Int,
    /** Элементы матрицы сопротивлений и проводимостей */
    val phaseImpedanceData: Array<PhaseImpedanceData>,
    override val aCLineSegments: Array<ACLineSegment>,
    override val rf_ACLineSeriesSection: Array<rf_ACLineSeriesSection>,
    override val wireAssemblyInfo: WireAssemblyInfo?,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : PerLengthImpedance

/** Аналоговый канал осциллограммы переменного тока */
class rf_ACAnalogChannel(
    /** Признак измерения первичной величины */
    val isPrimary: Boolean,
    /** Последовательность измеряемой трехфазной электрической величины */
    val sequence: rf_Sequences,
    /** Обмотка измерительного трансформатора, используемая для измерения величин токов и напряжений, регистрируемых в аналоговых каналах осциллограммы */
    val sensorWinding: rf_SensorWinding?,
    override val analog: Analog,
    override val number: Int,
    override val oscillograms: Array<rf_Oscillogram>,
    override val disturbanceRecorder: rf_DisturbanceRecorder?,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : rf_AnalogChannel