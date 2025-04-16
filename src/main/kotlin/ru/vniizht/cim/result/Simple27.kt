import ru.vniizht.model.result.UserAttribute
import ru.vniizht.model.result.WebServiceKind
import java.time.LocalDateTime
import java.util.*

/** Регулируемое шунтирующее компенсирующее устройство. Например, статический тиристорный компенсатор */
class StaticVarCompensator(
    /** Емкостное сопротивление при максимальной генерируемой реактивной мощности (положительное значение), Ом */
    val capacitiveRating: Double,
    /** Индуктивное сопротивление при максимальной потребляемой реактивной мощности (отрицательное значение), Ом */
    val inductiveRating: Double,
    /** Верхняя граница регулировочного диапазона, Мвар */
    val rf_maxQ: Double,
    /** Нижняя граница регулировочного диапазона, Мвар */
    val rf_minQ: Double,
    /** Активное сопротивление прямой последовательности, Ом */
    val rf_r: Double,
    /** Активное сопротивление нулевой последовательности, Ом */
    val rf_r0: Double,
    /** Статизм регулирования напряжения по реактивной мощности dU/dQ, кВ/Мвар */
    val slope: Double,
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
) : RegulatingCondEq

/** Функция режимной автоматики */
class rf_RegulatingAutomation(
    override val rf_algorithmVersion: String,
    override val conductingEquipments: Array<ConductingEquipment>,
    override val protectedSwitches: Array<ProtectedSwitch>,
    override val rf_SensorWindings: Array<rf_SensorWinding>,
    override val rf_OperationEvents: Array<rf_ProtectionOperationEvent>,
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
) : ProtectionEquipment

/** Заземляющий разъединитель */
class GroundDisconnector(
    override val rf_differenceInTransitTime: Double,
    override val normalOpen: Boolean,
    override val ratedCurrent: Double,
    override val open: Boolean,
    override val switchOnDate: LocalDateTime,
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
) : Switch

/** Предохранитель с плавкой вставкой */
class Fuse(
    override val rf_differenceInTransitTime: Double,
    override val normalOpen: Boolean,
    override val ratedCurrent: Double,
    override val open: Boolean,
    override val switchOnDate: LocalDateTime,
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
) : Switch

/** Датчик тока/напряжения линии электропередачи */
class PostLineSensor(
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

/** Точка доступа типа
Веб-сервис */
class rf_WSAccessPoint(
    /** Признак использования протокола HTTPS */
    val isHTTPS: Boolean,
    /** Строка подключения */
    val url: String,
    /** Тип Веб-сервиса */
    val wsKind: WebServiceKind,
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

/** Линейное шунтирующее компенсирующее устройство. Секции линейного шунтирующего компенсирующего устройства всегда имеют равные проводимости */
class LinearShuntCompensator(
    /** Активная проводимость нулевой последовательности на секцию, См */
    val g0PerSection: Double,
    /** Активная проводимость прямой последовательности на секцию, См */
    val gPerSection: Double,
    /** Реактивная проводимость нулевой последовательности на секцию, См */
    val b0PerSection: Double,
    /** Реактивная проводимость прямой последовательности на секцию, См */
    val bPerSection: Double,
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

/** Дугогасящая катушка Петерсена */
class PetersenCoil(
    /** Режим работы дугогасящей катушки. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val mode: PetersenCoilModeKind,
    /** Не скомпенсированный регулятором реактивный ток дугогасящей катушки, А */
    val offsetCurrent: Double,
    /** Максимальное реактивное сопротивление, Ом */
    val xGroundMax: Double,
    /** Минимальное реактивное сопротивление, Ом */
    val xGroundMin: Double,
    /** Номинальное реактивное сопротивление, Ом */
    val xGroundNominal: Double,
    /** Номинальное напряжение, кВ */
    val nominalU: Double,
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

/** Выключатель */
class Breaker(
    /** Время включения выключателя, с */
    val inTransitTime: Double,
    override val operatedByProtectionEquipment: Array<ProtectionEquipment>,
    override val breakingCapacity: Double,
    override val rf_differenceInTransitTime: Double,
    override val normalOpen: Boolean,
    override val ratedCurrent: Double,
    override val open: Boolean,
    override val switchOnDate: LocalDateTime,
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
) : ProtectedSwitch

/** Перемычка */
class Jumper(
    override val rf_differenceInTransitTime: Double,
    override val normalOpen: Boolean,
    override val ratedCurrent: Double,
    override val open: Boolean,
    override val switchOnDate: LocalDateTime,
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
) : Switch