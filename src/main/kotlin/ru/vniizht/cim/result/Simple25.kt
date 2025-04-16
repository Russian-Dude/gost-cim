import ru.vniizht.model.result.PerCent
import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Нелинейное шунтирующее компенсирующее устройство. Секции нелинейного шунтирующего компенсирующего устройства могут иметь неравные проводимости */
class NonlinearShuntCompensator(
    override val phaseConnection: PhaseShuntConnectionKind,
    override val nomU: Double,
    override val grounded: Boolean,
    override val maximumSections: Int,
    override val regulatingControl: RegulatingControl?,
    override val protectionEquipments: Array<ProtectionEquipment>,
    override val baseVoltage: BaseVoltage?,
    override val terminals: Array<Terminal>,
    override val rf_isThreePhaseEquipment: Boolean,
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
) : ShuntCompensator

/** Вещественная уставка, указываемая в управляющем воздействии */
class SetPoint(
    /** Нормальное значение для Control.value, например, используемое для процентного масштабирования */
    val normalValue: Double,
    override val maxValue: Double,
    override val minValue: Double,
    override val analogValue: AnalogValue,
    override val unitMultiplier: UnitMultiplier,
    override val unitSymbol: UnitSymbol,
    override val powerSystemResource: PowerSystemResource?,
    override val bilateralToIOPoint: Array<ProvidedBilateralPoint>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : AnalogControl

/** Индуктивное устройство заземления нейтрали для компенсации токов однофазных коротких замыканий */
class GroundingImpedance(
    /** Реактивное сопротивление устройства компенсации токов однофазного замыкания на землю, Ом */
    val x: Double,
    r: Double,
    protectionEquipments: Array<ProtectionEquipment>,
    baseVoltage: BaseVoltage?,
    terminals: Array<Terminal>,
    rf_isThreePhaseEquipment: Boolean,
    faults: Array<Fault>,
    outages: Array<Outage>,
    normallyInService: Boolean,
    equipmentContainer: EquipmentContainer?,
    additionalEquipmentContainer: Array<EquipmentContainer>,
    usagePoints: Array<UsagePoint>,
    limitDependencyModel: Array<LimitDependency>,
    operationalLimitSet: Array<OperationalLimitSet>,
    rf_VoltageLimitDurationCurve: rf_VoltageLimitDurationCurve?,
    assets: Array<Asset>,
    pSRType: PSRType?,
    measurements: Array<Measurement>,
    location: Location?,
    assetDatasheet: AssetInfo?,
    controls: Array<Control>,
    aliasName: String,
    description: String,
    mRID: UUID,
    name: String,
    names: Array<Name>,
    rf_OrganisationRoles: Array<OrganisationRole>,
    rf_CustomAttributes: Array<UserAttribute>,
    diagramObjects: Array<DiagramObject>
) : EarthFaultCompensator(
    r = r,
    protectionEquipments = protectionEquipments,
    baseVoltage = baseVoltage,
    terminals = terminals,
    rf_isThreePhaseEquipment = rf_isThreePhaseEquipment,
    faults = faults,
    outages = outages,
    normallyInService = normallyInService,
    equipmentContainer = equipmentContainer,
    additionalEquipmentContainer = additionalEquipmentContainer,
    usagePoints = usagePoints,
    limitDependencyModel = limitDependencyModel,
    operationalLimitSet = operationalLimitSet,
    rf_VoltageLimitDurationCurve = rf_VoltageLimitDurationCurve,
    assets = assets,
    pSRType = pSRType,
    measurements = measurements,
    location = location,
    assetDatasheet = assetDatasheet,
    controls = controls,
    aliasName = aliasName,
    description = description,
    mRID = mRID,
    name = name,
    names = names,
    rf_OrganisationRoles = rf_OrganisationRoles,
    rf_CustomAttributes = rf_CustomAttributes,
    diagramObjects = diagramObjects
)

/** Трансформатор напряжения */
class PotentialTransformer(
    /** Класс точности */
    val accuracyClass: String,
    /** Конструктивный тип. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val type: PotentialTransformerKind,
    /** Номинальное напряжение, кВ */
    val rf_nominalVoltage: Double,
    /** Обмотки трансформатора напряжения */
    val rf_Windings: Array<rf_PotentialTransformerWinding>,
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
) : Sensor

/** Устройство учета электрической энергии, которое выполняет измерительную функцию в точке поставки */
class Meter(
    /** Обозначение формы прибора учета (см. [1] или другой применимый стандарт). Буквенно-цифровое обозначение, представляющее схему, для которой применяется прибор учета, и его конкретное расположение клемм */
    val formNumber: String,
    /** Коэффициенты, применяемые на приборе учета */
    val meterMultipliers: Array<MeterMultiplier>,
    /** Показания прибора учета, предоставляемые прибором учета */
    val meterReadings: Array<MeterReading>,
    timeZoneOffset: Double,
    customer: Customer?,
    usagePoint: UsagePoint?,
    installCode: String,
    isPan: Boolean,
    isVirtual: Boolean,
    endDeviceFunctions: Array<EndDeviceFunction>,
    endDeviceInfo: EndDeviceInfo?,
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
) : EndDevice(
    timeZoneOffset = timeZoneOffset,
    customer = customer,
    usagePoint = usagePoint,
    installCode = installCode,
    isPan = isPan,
    isVirtual = isVirtual,
    endDeviceFunctions = endDeviceFunctions,
    endDeviceInfo = endDeviceInfo,
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

/** Токосъемник - точка гальванического присоединения к участку ЛЭП дополнительного электропроводящего оборудования */
class Clamp(
    /** Расстояние до места присоединения к участку ЛЭП, вычисляемое от полюса ЛЭП с порядковым номером 1, м */
    val lengthFromTerminal1: Double,
    /** Участок ЛЭП, к которому подключен токосъемник */
    val aCLineSegment: ACLineSegment,
    override val protectionEquipments: Array<ProtectionEquipment>,
    override val baseVoltage: BaseVoltage?,
    override val terminals: Array<Terminal>,
    override val rf_isThreePhaseEquipment: Boolean,
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
) : ConductingEquipment

/** Документ, представляющий собой техническую спецификацию, относящуюся к устройству РЗА */
class rf_PACSTechnicalSpecification(
    /** Вид технической спецификации */
    val rf_kind: rf_PACSTechnicalSpecificationKind,
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

/** Точка доступа ICCP. Набор адресной информации, необходимой для подключения по протоколу ICCP */
class ISOUpperLayer(
    /** Строка, состоящая из последовательности десятичных чисел, разделенных точками. Значение атрибута в целом совместно с другими адресными атрибутами используется для выбора определенного приложения (например, приложения ICCP) в базовой модели OSI. Последовательность и ее значения составляют пространство имен (см. [7]) */
    val apTitle: String,
    /** Презентационный селектор. Адресный селектор уровня представления базовой модели OSI */
    val osiPsel: String,
    /** Сессионный селектор. Адресная информация уровня сессии базовой модели OSI */
    val osiSsel: String,
    /** Транспортный селектор. Адресная информация транспортного уровня базовой модели OSI */
    val osiTsel: String,
    /** Дополнительный адрес приложения. Адресный параметр дополнительного уровня приложения базовой модели OSI */
    val apInvoke: Int,
    /** Адресный параметр уровня подсистемы приложения в соответствии с системой адресации ISO */
    val aeInvoke: Int,
    /** Дополнительный уровень адресной информации приложения, выделяющий подсистему приложения */
    val aeQual: Int,
    /** Сертификаты, привязанные к точке доступа для использования на уровне приложения */
    val upperLayerPublicX509Certificate: Array<PublicX509Certificate>,
    override val keepAliveTime: Int,
    override val port: Int,
    override val publicX509Certificate: Array<PublicX509Certificate>,
    override val address: String,
    override val addressType: IPAddressKind,
    override val gateway: String,
    override val subnet: String,
    override val nonoperativeTechnologicalData: Array<rf_NonoperativeTechnologicalData>,
    override val bilateralExchangActor: BilateralExchangeActor?,
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
) : TCPAccessPoint

/** Фотоэлектрический солнечный модуль или группа модулей */
class PhotoVoltaicUnit(
    override val rf_deadband: Double,
    override val rf_governorSCD: Double,
    override val maxP: Double,
    override val minP: Double,
    override val powerElectronicsConnection: PowerElectronicsConnection,
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
) : PowerElectronicsUnit

/** Потребитель электрической энергии (обобщенное понятие) - точка потребления */
class EnergyConsumer(
    /** Количество индивидуальных потребителей, представленных данной точкой потребления */
    val customerCount: Int,
    override val protectionEquipments: Array<ProtectionEquipment>,
    override val baseVoltage: BaseVoltage?,
    override val terminals: Array<Terminal>,
    override val rf_isThreePhaseEquipment: Boolean,
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
) : ConductingEquipment