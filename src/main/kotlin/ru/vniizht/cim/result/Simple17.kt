import ru.vniizht.model.result.PerCent
import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Простая функция конечного устройства, отличающаяся "видом" */
class SimpleEndDeviceFunction(
    /** Вид функции */
    val kind: EndDeviceFunctionKind,
    override val enabled: Boolean,
    override val registers: Array<Register>,
    override val configID: String,
    override val firmwareID: String,
    override val hardwareID: String,
    override val password: String,
    override val programID: String,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : EndDeviceFunction

/** Событие срабатывания или пуска устройства РЗА */
class rf_PACSDeviceOperationEvent(
    /** Устройство РЗА, которое сработало/пустилось при определенном событии */
    val pACSDevice: rf_PACSDevice,
    rf_kind: rf_OperationKind,
    rf_operationMark: rf_ProtectionOperationMark,
    rf_personnelCode: rf_PersonnelCode,
    rf_techReasonCode: rf_TechReasonCode,
    rf_orgReasonCode: rf_OrgReasonCode,
    fault: Fault?,
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
) : rf_PACSOperationEvent(
    rf_kind = rf_kind,
    rf_operationMark = rf_operationMark,
    rf_personnelCode = rf_personnelCode,
    rf_techReasonCode = rf_techReasonCode,
    rf_orgReasonCode = rf_orgReasonCode,
    fault = fault,
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

/** Управляющее воздействие на дискретную величину (включить, отключить, пр.) */
class Command(
    /** Нормальное значение атрибута "value", используется для нормирования */
    val normalValue: Int,
    /** Набор именованных значений для воздействий, которые могут встретиться в данной команде */
    val valueAliasSet: ValueAliasSet?,
    /** Значение измерения управляемого параметра */
    val discreteValue: DiscreteValue,
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
) : Control

/** Организация - производитель определенного типа оборудования */
class Manufacturer(
    /** Модели оборудования определенного производителя */
    val productAssetModel: Array<ProductAssetModel>,
    rf_Objects: Array<IdentifiedObject>,
    organisation: Organisation?,
    configurationEvents: Array<ConfigurationEvent>,
    aliasName: String,
    description: String,
    mRID: UUID,
    name: String,
    names: Array<Name>,
    rf_OrganisationRoles: Array<OrganisationRole>,
    rf_CustomAttributes: Array<UserAttribute>,
    diagramObjects: Array<DiagramObject>
) : OrganisationRole(
    rf_Objects = rf_Objects,
    organisation = organisation,
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

/** Эксплуатационное ограничение/предел по активной мощности */
class ActivePowerLimit(
    /** Нормальное значение эксплуатационного ограничения/предела по активной мощности, МВт */
    val normalValue: Double,
    /** Значение эксплуатационного ограничения/предела по активной мощности, МВт */
    val value: Double,
    override val limitDependencyModel: Array<LimitDependency>,
    override val limitScalingLimit: Array<LimitScalingLimit>,
    override val operationalLimitSet: OperationalLimitSet,
    override val operationalLimitType: OperationalLimitType?,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : OperationalLimit

/** P-Q диаграмма синхронной машины */
class ReactiveCapabilityCurve(
    /** Синхронные машины, для которых задана P-Q диаграмма по умолчанию */
    val initiallyUsedBySynchronousMachines: Array<SynchronousMachine>,
    /** Синхронные машины, для которых задана P-Q диаграмма */
    val synchronousMachines: Array<SynchronousMachine>,
    override val curveStyle: CurveStyle,
    override val xMultiplier: UnitMultiplier,
    override val xUnit: UnitSymbol,
    override val y1Multiplier: UnitMultiplier,
    override val y1Unit: UnitSymbol,
    override val y2Multiplier: UnitMultiplier,
    override val y2Unit: UnitSymbol,
    override val y3Multiplier: UnitMultiplier,
    override val y3Unit: UnitSymbol,
    override val curveDatas: Array<CurveData>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : Curve

/** Подстанция */
class Substation(
    /** Электростанция, к которой относится группа распределительных устройств */
    val rf_Plant: Plant?,
    /** (агрегирование)
    Субъект Российской Федерации, на территории которого находится подстанция */
    val region: SubGeographicalRegion?,
    /** Распределительные устройства, входящие в состав подстанции */
    val voltageLevels: Array<VoltageLevel>,
    /** Питающие линии, посредством которых подается напряжение на подстанцию */
    val normalEnergizingFeeder: Array<Feeder>,
    /** Питающие линии, на которые по нормальной схеме подается напряжение от данной подстанции */
    val normalEnergizedFeeder: Array<Feeder>,
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

/** Роль организации - потребитель электрической энергии */
class Customer(
    /** Все официальные соглашения с потребителем электроэнергии */
    val customerAgreements: Array<CustomerAgreement>,
    /** Оконечные устройства клиента */
    val endDevices: Array<EndDevice>,
    /** Вид клиента */
    val kind: CustomerKind,
    /** Язык общения с клиентом */
    val locale: String,
    /** Идентификационный номер органа исполнительной власти субъекта Российской Федерации в области государственного регулирования тарифов и цен (PUC) */
    val pucNumber: String,
    /** TRUE, если потребитель относится к категории потребителей, ограничение режима потребления электрической энергии (мощности) которого может привести к экономическим, экологическим, социальным последствиям, например жизнеобеспечение больницы */
    val specialNeed: String,
    /** Состояние потребителя */
    val status: Status,
    /** TRUE, если потребитель относится к первой категории надежности электроснабжения */
    val vip: Boolean,
    rf_Objects: Array<IdentifiedObject>,
    organisation: Organisation?,
    configurationEvents: Array<ConfigurationEvent>,
    aliasName: String,
    description: String,
    mRID: UUID,
    name: String,
    names: Array<Name>,
    rf_OrganisationRoles: Array<OrganisationRole>,
    rf_CustomAttributes: Array<UserAttribute>,
    diagramObjects: Array<DiagramObject>
) : OrganisationRole(
    rf_Objects = rf_Objects,
    organisation = organisation,
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

/** Технические параметры выключателя */
class BreakerInfo(
    /** Полное время отключения выключателя, с */
    val rf_interruptingTime: Double,
    /** Нормированная бестоковая пауза при автоматическом повторном включении, с */
    val rf_ratedRecloseTime: Double,
    breakingCapacity: Double,
    ratedCurrent: Double,
    ratedInterruptingTime: Double,
    rf_ratedInTransitTime: Double,
    ratedVoltage: Double,
    isSinglePhase: Boolean,
    isUnganged: Boolean,
    rf_isUngangedControl: Boolean,
    productAssetModel: ProductAssetModel?,
    assets: Array<Asset>,
    powerSystemResources: Array<PowerSystemResource>,
    aliasName: String,
    description: String,
    mRID: UUID,
    name: String,
    names: Array<Name>,
    rf_OrganisationRoles: Array<OrganisationRole>,
    rf_CustomAttributes: Array<UserAttribute>,
    diagramObjects: Array<DiagramObject>
) : OldSwitchInfo(
    breakingCapacity = breakingCapacity,
    ratedCurrent = ratedCurrent,
    ratedInterruptingTime = ratedInterruptingTime,
    rf_ratedInTransitTime = rf_ratedInTransitTime,
    ratedVoltage = ratedVoltage,
    isSinglePhase = isSinglePhase,
    isUnganged = isUnganged,
    rf_isUngangedControl = rf_isUngangedControl,
    productAssetModel = productAssetModel,
    assets = assets,
    powerSystemResources = powerSystemResources,
    aliasName = aliasName,
    description = description,
    mRID = mRID,
    name = name,
    names = names,
    rf_OrganisationRoles = rf_OrganisationRoles,
    rf_CustomAttributes = rf_CustomAttributes,
    diagramObjects = diagramObjects
)

/** Материальный объект, который может состоять из других материальных объектов */
open class AssetContainer(
    /** Материальные объекты, которые входят в состав текущего материального объекта */
    val assets: Array<Asset>,
    /** Пломбы, применяемые к контейнеру материальных объектов */
    val seals: Array<Seal>,
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
) : Asset(
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