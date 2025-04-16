import ru.vniizht.model.result.PerCent
import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Котел-утилизатор */
class HeatRecoveryBoiler(
    /** Газовая турбина котла-утилизатора */
    val combustionTurbines: Array<CombustionTurbine>,
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

/** Гидротурбина */
class HydroTurbine(
    /** Тип турбины. Справочный класс профиля генерирующего оборудования в соответствии с приложением А */
    val turbineType: HydroTurbineKind,
    override val rf_AsynchronousMachine: AsynchronousMachine?,
    override val synchronousMachines: Array<SynchronousMachine>,
    override val rf_ratedPower: Double,
    override val rf_rotationSpeed: Double,
    override val rf_rotorGD2: Double,
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
) : PrimeMover

/** Контейнер материальных объектов, содержащий одну или несколько функций РЗА */
class rf_PACSDevice(
    /** Версия программного обеспечения, установленного на устройстве РЗА */
    val rf_firmwareID: String,
    /** Вид контейнера материальных объектов, содержащего одну или несколько функций РЗА */
    val rf_kind: rf_PACSDeviceKind,
    /** Элементная база контейнера материальных объектов, содержащего одну или несколько функций РЗА */
    val rf_elementBaseKind: rf_ElementBaseKind,
    /** Техническая или эксплуатационная документация, которая относится к контейнеру материальных объектов, содержащему одну или несколько функций РЗА */
    val pACSDeviceSpecifications: Array<rf_PACSDeviceSpecification>,
    /** События срабатывания/пуска для данного устройства РЗА */
    val rf_OperationEvents: Array<rf_PACSDeviceOperationEvent>,
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

/** Удельные электрические параметры участка ЛЭП */
class PerLengthSequenceImpedance(
    /** Удельная емкостная проводимость участка ЛЭП нулевой последовательности, См/м */
    val b0ch: Double,
    /** Удельная емкостная проводимость участка ЛЭП прямой последовательности, См/м */
    val bch: Double,
    /** Удельная активная проводимость участка ЛЭП нулевой последовательности, См/м */
    val g0ch: Double,
    /** Удельная активная проводимость участка ЛЭП прямой последовательности, См/м */
    val gch: Double,
    /** Удельное активное сопротивление участка ЛЭП прямой последовательности, Ом/м */
    val r: Double,
    /** Удельное активное сопротивление участка ЛЭП нулевой последовательности, Ом/м */
    val r0: Double,
    /** Удельное реактивное сопротивление участка ЛЭП прямой последовательности, Ом/м */
    val x: Double,
    /** Удельное реактивное сопротивление участка ЛЭП нулевой последовательности, Ом/м */
    val x0: Double,
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

/** Фазовращатель симметричный. Фазовращатель симметричный, осуществляющий продольно-поперечное регулирование при сохранении неизменным модуля коэффициента трансформации */
class PhaseTapChangerSymmetrical(
    override val voltageStepIncrement: Double,
    override val xMax: Double,
    override val xMin: Double,
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
) : PhaseTapChangerNonLinear

/** Договор с потребителем электрической энергии */
class CustomerAgreement(
    /** Потребитель электроэнергии, к которому относится соглашение */
    val customer: Customer,
    /** Точки поставки, относящиеся к договору с потребителем */
    val usagePoints: Array<UsagePoint>,
    /** Код управления нагрузкой */
    val loadMgmt: String,
    /** Категория услуг по договору */
    val serviceCategory: ServiceCategory?,
    signDate: LocalDateTime,
    validityInterval: DateTimeInterval,
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
) : Agreement(
    signDate = signDate,
    validityInterval = validityInterval,
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

/** Документ, предназначенный для описания параметров задания по настройке устройств РЗА */
class rf_PACSSettingsSpecification(
    /** Вид документа, предназначенного для описания параметров задания по настройке устройства РЗА */
    val rf_kind: rf_PACSSettingsSpecificationKind,
    pACSDevice: rf_PACSDevice,
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
) : rf_PACSDeviceSpecification(
    pACSDevice = pACSDevice,
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

/** Газовая турбина */
class CombustionTurbine(
    /** Котел-утилизатор газовой турбины */
    val heatRecoveryBoiler: HeatRecoveryBoiler?,
    override val rf_AsynchronousMachine: AsynchronousMachine?,
    override val synchronousMachines: Array<SynchronousMachine>,
    override val rf_ratedPower: Double,
    override val rf_rotationSpeed: Double,
    override val rf_rotorGD2: Double,
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
) : PrimeMover

/** Система возбуждения */
class rf_ExcitationSystem(
    /** Кратность расфорсировки возбуждения по напряжению по отношению к номинальным параметрам возбуждения, о.е. */
    val voltageDeexcitationRatio: Double,
    /** Полное время расфорсировки, с */
    val fullDeexcitationTime: Double,
    /** Запаздывание при форсировке, с */
    val excitationForcingDelay: Double,
    /** Длительность форсировки, с */
    val excitationForcingDuration: Double,
    /** Быстродействие системы возбуждения при форсировке, с */
    val excitationForcingRapidity: Double,
    /** Кратность форсировки возбуждения по току по отношению к номинальным параметрам возбуждения, о.е. */
    val currentExcitationForcingRatio: Double,
    /** Время допустимой перегрузки при двукратном номинальном токе возбуждения, с */
    val maxDoubleOverloadTime: Double,
    /** Кратность форсировки возбуждения по напряжению по отношению к номинальным параметрам возбуждения, о.е./с */
    val voltageExcitationForcingRatio: Double,
    /** Номинальная скорость нарастания напряжения возбуждения, о.е./с */
    val voltageExcitationRampRate: Double,
    /** Время задержки на снятие релейной форсировки, с */
    val relayExcitationReleaseDelay: Double,
    /** Напряжение возврата (снятия) релейной форсировки, кВ */
    val relayExcitationReleaseVoltage: Double,
    /** Напряжение срабатывания (ввода) релейной форсировки, кВ */
    val relayExcitationTriggerVoltage: Double,
    /** Маховой момент возбудителя (за исключением статических тиристорных систем возбуждения), т·м2 */
    val rotorGD2: Double,
    /** Эквивалентная постоянная времени возбудителя для высокочастотной и электромашинной системы возбуждения, с */
    val timeConstant: Double,
    /** Время допустимой перегрузки при двукратном номинальном токе возбуждения, с */
    val timeDoubleCurrentOverload: Double,
    /** Генератор, к которому относится система возбуждения */
    val rf_SynchronousMachine: Array<SynchronousMachine>,
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
) : Equipment

/** Паровая турбина */
class SteamTurbine(
    /** Котлы, снабжающие паровую турбину */
    val steamSupplies: Array<SteamSupply>,
    override val rf_AsynchronousMachine: AsynchronousMachine?,
    override val synchronousMachines: Array<SynchronousMachine>,
    override val rf_ratedPower: Double,
    override val rf_rotationSpeed: Double,
    override val rf_rotorGD2: Double,
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
) : PrimeMover