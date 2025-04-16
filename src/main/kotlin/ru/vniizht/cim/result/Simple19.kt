import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Фазоповоротное устройство с линейной зависимостью */
class PhaseTapChangerLinear(
    /** Изменение фазового угла при изменении позиции регулировочного ответвления на один шаг, град */
    val stepPhaseShiftIncrement: Double,
    /** Максимальное индуктивное сопротивление луча звезды, Ом. Зависимость значения от номера регулировочного ответвления U-образна. Указанное этим атрибутом значение характерно для двух крайних ответвлений: нижнего и верхнего */
    val xMax: Double,
    /** Минимальное индуктивное сопротивление луча звезды, Ом. Зависимость значения от номера регулировочного ответвления U-образна. Указанное этим атрибутом значение характерно для двух крайних ответвлений: нижнего и верхнего */
    val xMin: Double,
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

/** Расположение точки учета */
class UsagePointLocation(
    /** Точки учета, расположенные в данном месте */
    val usagePoints: Array<UsagePoint>,
    /** Способ доступа обслуживающего персонала к расположению точки поставки */
    val accessMethod: String,
    /** Заметки о расположении точки поставки */
    val remark: String,
    /** Проблемы (недопуска к средствам измерений), с которыми ранее сталкивались при посещении или выполнении работы в расположении точки поставки */
    val siteAccessProblem: String,
    electronicAddress: ElectronicAddress,
    mainAddress: StreetAddress,
    phone1: TelephoneNumber,
    phone2: TelephoneNumber,
    secondaryAddress: StreetAddress,
    assets: Array<Asset>,
    coordinateSystem: CoordinateSystem?,
    positionPoints: Array<PositionPoint>,
    powerSystemResources: Array<PowerSystemResource>,
    direction: String,
    geoInfoReference: String,
    status: Status,
    type: String,
    configurationEvents: Array<ConfigurationEvent>,
    aliasName: String,
    description: String,
    mRID: UUID,
    name: String,
    names: Array<Name>,
    rf_OrganisationRoles: Array<OrganisationRole>,
    rf_CustomAttributes: Array<UserAttribute>,
    diagramObjects: Array<DiagramObject>
) : Location(
    electronicAddress = electronicAddress,
    mainAddress = mainAddress,
    phone1 = phone1,
    phone2 = phone2,
    secondaryAddress = secondaryAddress,
    assets = assets,
    coordinateSystem = coordinateSystem,
    positionPoints = positionPoints,
    powerSystemResources = powerSystemResources,
    direction = direction,
    geoInfoReference = geoInfoReference,
    status = status,
    type = type,
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

/** Корпус силового трансформатора */
class TransformerTank(
    /** Силовой трансформатор, к которому относится корпус */
    val powerTransformer: PowerTransformer?,
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

/** Эксплуатационное ограничение/предел по току */
class CurrentLimit(
    /** Нормальное значение эксплуатационного ограничения/предела по току, А */
    val normalValue: Double,
    /** Значение эксплуатационного ограничения/предела по току, А */
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

/** Функция, которая отключает и повторно подключает нагрузку клиента при определенных условиях */
class ConnectDisconnectFunction(
    /** Запуск кумулятивного подсчета событий подключения или отключения в течение всего срока службы функции или до тех пор, пока значение не будет очищено */
    val eventCount: Int,
    /** TRUE, если функция, указанная в предыдущей позиции, находится в подключенном состоянии */
    val isConnected: Boolean,
    /** Если установлено значение TRUE, коммутатор может отключить службу в конце заданной временной задержки после подачи сигнала отключения. Если установлено значение FALSE, коммутатор может отключить службу сразу же после подачи сигнала об отключении */
    val isDelayedDiscon: Boolean,
    /** Если установлено значение TRUE и если отключение, указанное в предыдущей позиции, может осуществляться локально, то операция происходит автоматически. В противном случае это происходит вручную */
    val isLocalAutoDisconOp: Boolean,
    /** Если установлено значение TRUE и если повторное подключение после отключения, указанного в предыдущей позиции, может выполняться локально, то операция происходит автоматически. В противном случае это происходит вручную */
    val isLocalAutoReconOp: Boolean,
    /** Если установлено значение TRUE и если отключение, указанное в предыдущей позиции, может управляться удаленно, то операция происходит автоматически. Если установлено значение FALSE и отключением можно управлять удаленно, то операция выполняется вручную */
    val isRemoteAutoDisconOp: Boolean,
    /** Если установлено значение TRUE и если повторное подключение после отключения, указанного в предыдущей позиции, может осуществляться удаленно, то операция происходит автоматически. Если установлено значение FALSE и если повторное подключение может осуществляться удаленно, то операция выполняется вручную */
    val isRemoteAutoReconOp: Boolean,
    /** Информация о реле включения/отключения */
    val rcdInfo: RemoteConnectDisconnectInfo,
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

/** Электростанция */
class Plant(
    /** Субъект Российской Федерации, на территории которого находится электростанция */
    val rf_Region: SubGeographicalRegion?,
    /** Группы распределительных устройств электростанции */
    val rf_Substations: Array<Substation>,
    /** Установленная мощность электростанции, МВт */
    val rf_ratedP: Double,
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

/** Вторичная обмотка трансформатора тока */
class rf_CurrentTransformerWinding(
    /** Предельная кратность, о.е. */
    val kMax: Double,
    /** Активное сопротивление обмотки, Ом */
    val r: Double,
    /** Активное сопротивление нагрузки, Ом */
    val ratedLoadR: Double,
    /** Коэффициент трансформации (выбранное ответвление) */
    val kt: Double,
    /** Реактивное сопротивление обмотки, Ом */
    val x: Double,
    /** Реактивное сопротивление нагрузки, Ом */
    val ratedLoadX: Double,
    /** Номинальные коэффициенты трансформации обмотки (для всех ответвлений). Указывается в форме отношения номинальных первичных и вторичных токов. Для трансформаторов, у которых коэффициент трансформации меняется путем изменения числа витков первичных обмоток, номинальные первичные токи указывают через тире -, например 300 - 600 - 1200/5 А. Для трансформаторов, у которых коэффициент трансформации меняется путем изменения числа витков вторичных обмоток, первичные токи указывают через косую черту, например, 300/600/1200/5 А */
    val nominalKTs: String,
    /** Трансформатор тока, к которому относится обмотка */
    val rf_Transformer: CurrentTransformer,
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

/** Система управления переключателем регулировочных ответвлений трансформатора */
class TapChangerControl(
    /** Переключатель регулировочных ответвлений обмотки, на которые воздействует система управления */
    val tapChanger: Array<TapChanger>,
    enabled: Boolean,
    mode: RegulatingControlModeKind,
    regulatingCondEq: Array<RegulatingCondEq>,
    terminal: Terminal?,
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
) : RegulatingControl(
    enabled = enabled,
    mode = mode,
    regulatingCondEq = regulatingCondEq,
    terminal = terminal,
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

/** Ограничитель перенапряжения */
class SurgeArrester(
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

/** Автоматический регулятор возбуждения */
class rf_ExcitationControl(
    /** Тип системного стабилизатора (В соответствии с международным стандартом [4]) */
    val stabilizerType: String,
    /** Тип регулятора напряжения (В соответствии с международным стандартом [4]) */
    val voltageControlType: String,
    /** Система возбуждения */
    val rf_ExcitationSystem: rf_ExcitationSystem,
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