import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Водо-водяной энергетический ядерный реактор (ВВЭР) */
class PWRSteamSupply(
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

/** Атомный энергоблок */
class NuclearGeneratingUnit(
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

/** Эквивалент для поставщика электрической энергии на уровне напряжения передачи или распределения электрической энергии */
class EnergySource(
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

/** Котел высокого давления */
class Subcritical(
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

/** Документ, представляющий собой схему, относящуюся к устройству РЗА */
class rf_PACSDiagramSpecification(
    /** Вид схемы */
    val rf_kind: rf_PACSDiagramSpecificationKind,
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

/** Ветряная энергоустановка или ветропарк, подключаемые в сеть с использованием устройств на базе силовой электроники */
class PowerElectronicsWindUnit(
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

/** Указатель повреждения - индикатор для определения поврежденного участка линии электропередачи и сигнализации о произошедшей аварийной ситуации */
class FaultIndicator(
    /** Ток срабатывания, А */
    val rf_operationCurrent: Double,
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

/** Аналоговый канал осциллограммы постоянного тока */
class rf_DCAnalogChannel(
    /** Тип аналогового канала постоянного тока по измеряемому напряжению */
    val dCVoltageMeasType: rf_DCVoltageType,
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

/** Функция релейной защиты */
class rf_RelayProtection(
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

/** Силовой трансформатор */
class PowerTransformer(
    /** Электрические выводы силового трансформатора */
    val powerTransformerEnd: Array<PowerTransformerEnd>,
    /** Группа соединения обмоток (Строка, определяющая напряжения, группу соединения, схему соединения обмоток) */
    val vectorGroup: String,
    /** Корпуса силового трансформатора */
    val transformerTanks: Array<TransformerTank>,
    /** Компенсационные обмотки трансформатора */
    val rf_StabilizingWindings: Array<rf_StabilizingWinding>,
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