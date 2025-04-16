import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Разъединитель */
class Disconnector(
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

/** Асинхронная машина */
class AsynchronousMachine(
    /** Первичный двигатель асинхронного генератора */
    val rf_PrimeMover: PrimeMover?,
    /** Режимы работы, в которых асинхронная машина способна работать. Справочный класс профиля генерирующего оборудования в соответствии с приложением А */
    val asynchronousMachineType: AsynchronousMachineKind,
    /** Коэффициент полезного действия, % */
    val efficiency: Double,
    /** Номинальная механическая мощность, МВт */
    val ratedMechanicalPower: Double,
    /** P-Q диаграмма асинхронной машины */
    val rf_ReactiveCapabilityCurve: rf_AsynchronousMachineReactiveCapabilityCurve?,
    /** Моментно-скоростная характеристика */
    val rf_TorqueSpeedCurve: rf_TorqueSpeedCurve?,
    override val generatingUnit: GeneratingUnit?,
    override val ratedPowerFactor: Double,
    override val ratedS: Double,
    override val ratedU: Double,
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
) : RotatingMachine

/** Параметры подробной динамической модели синхронной машины */
class SynchronousMachineTimeConstantReactance(
    /** Тип ротора синхронной машины. Справочный класс профиля генерирующего оборудования в соответствии с приложением А */
    val rotorType: RotorKind,
    /** Постоянная времени обмотки возбуждения при разомкнутой обмотке якоря Td0, с */
    val rf_tdo: Double,
    /** Постоянная времени обмотки возбуждения при короткозамкнутой обмотке якоря , с */
    val rf_tpd: Double,
    /** Постоянная времени (переходная) обмотки возбуждения при разомкнутой обмотке якоря по продольной оси , с */
    val tpdo: Double,
    /** Постоянная времени демпферной обмотки при короткозамкнутых обмотках якоря и возбуждения по продольной оси , с */
    val rf_tppd: Double,
    /** Постоянная времени демпферной обмотки при разомкнутых обмотках якоря и возбуждения по продольной оси , с */
    val tppdo: Double,
    /** Постоянная времени демпферной обмотки при короткозамкнутых обмотках якоря и возбуждения по поперечной оси , с */
    val rf_tppq: Double,
    /** Постоянная времени демпферной обмотки при разомкнутых обмотках якоря и возбуждения по поперечной оси , с */
    val tppqo: Double,
    /** Постоянная времени (переходная) обмотки возбуждения при разомкнутой обмотке якоря по поперечной оси , с */
    val tpqo: Double,
    /** Реактивное сверхпереходное сопротивление по продольной оси , о.е. */
    val xDirectSubtrans: Double,
    /** Синхронное реактивное сопротивление по продольной оси Xd, о.е. */
    val xDirectSync: Double,
    /** Переходное реактивное сопротивление по продольной оси , о.е. */
    val xDirectTrans: Double,
    /** Сверхпереходное реактивное сопротивление по поперечной оси , о.е. */
    val xQuadSubtrans: Double,
    /** Синхронное реактивное сопротивление по поперечной оси Xq, о.е. */
    val xQuadSync: Double,
    /** Переходное реактивное сопротивление по поперечной оси , о.е. */
    val xQuadTrans: Double,
    override val synchronousMachine: SynchronousMachine?,
    override val inertia: Double,
    override val statorLeakageReactance: Double,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : SynchronousMachineDetailed

/** Трансформатор тока */
class CurrentTransformer(
    /** Класс точности */
    val accuracyClass: String,
    /** Трансформатор тока встроенный (если присвоено значение "Истина") */
    val rf_isEmbeded: Boolean,
    /** Номинальный ток, А */
    val rf_ratedCurrent: Double,
    /** Номинальный вторичный ток, А */
    val rf_ratedSecondaryCurrent: Double,
    /** Обмотки трансформатора тока */
    val rf_Windings: Array<rf_CurrentTransformerWinding>,
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

/** Функция технологической автоматики */
class rf_OperationControlAutomation(
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

/** Временный разрыв линии */
class Cut(
    /** Расстояние до места разрыва участка ЛЭП, вычисляемое от полюса ЛЭП с порядковым номером 1, м */
    val lengthFromTerminal1: Double,
    /** Участок ЛЭП, на котором выполнен временный разрыв */
    val aCLineSegment: ACLineSegment,
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

/** Секция шин */
class BusbarSection(
    /** Максимально допустимый пиковый ток короткого замыкания, А */
    val ipMax: Double,
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
) : Connector

/** Участок линии переменного тока */
class ACLineSegment(
    /** Активная проводимость на землю нулевой последовательности, См */
    val g0ch: Double,
    /** Активная проводимость на землю прямой последовательности, См */
    val gch: Double,
    /** Реактивное сопротивление прямой последовательности, Ом */
    val x: Double,
    /** Реактивное сопротивление нулевой последовательности, Ом */
    val x0: Double,
    /** Активное сопротивление прямой последовательности, Ом */
    val r: Double,
    /** Активное сопротивление нулевой последовательности, Ом */
    val r0: Double,
    /** Реактивная проводимость на землю нулевой последовательности, См */
    val b0ch: Double,
    /** Реактивная проводимость на землю прямой последовательности, См */
    val bch: Double,
    /** Фаза участка линии переменного тока */
    val aCLineSegmentPhases: Array<ACLineSegmentPhase>,
    /** Сегменты участка линии переменного тока */
    val rf_ACLineSeriesSections: Array<rf_ACLineSeriesSection>,
    /** Удельные параметры участка линии переменного тока */
    val perLengthImpedance: PerLengthImpedance?,
    /** Токосъемники, подключенные к участку ЛЭП */
    val clamp: Array<Clamp>,
    /** Временные разрывы участка ЛЭП */
    val cut: Array<Cut>,
    override val length: Double,
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
) : Conductor

/** Функция сетевой автоматики */
class rf_ControlAutomation(
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

/** Функция противоаварийной автоматики */
class rf_EmergencyControlAutomation(
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