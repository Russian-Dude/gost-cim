import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Эксплуатационное ограничение/предел по напряжению */
class VoltageLimit(
    /** Нормальное значение эксплуатационного ограничения/предела по напряжению, кВ */
    val normalValue: Double,
    /** Значение эксплуатационного ограничения/предела по напряжению, кВ */
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

/** Распределительное устройство */
class VoltageLevel(
    /** Стандартное номинальное напряжение распределительного устройства */
    val baseVoltage: BaseVoltage?,
    /** Присоединения распределительного устройства */
    val bays: Array<Bay>,
    /** (агрегирование)
    Подстанция, в состав которой входит распределительное устройство */
    val substation: Substation,
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

/** Значение дискретного параметра */
class DiscreteValue(
    /** Значение дискретного измерения */
    val value: Int,
    /** Измеряемый дискретный параметр */
    val discrete: Discrete,
    /** Управляющее воздействие на измеряемую величину */
    val command: Command?,
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
) : MeasurementValue

/** Электрический вывод силового трансформатора */
class PowerTransformerEnd(
    /** Силовой трансформатор, к которому относится вывод */
    val powerTransformer: PowerTransformer?,
    /** Реактивная проводимость прямой последовательности шунта намагничивания, приведенная к номинальному напряжению вывода с наивысшим напряжением, См */
    val b: Double,
    /** Реактивная проводимость нулевой последовательности шунта намагничивания, приведенная к номинальному напряжению вывода с наивысшим напряжением, См */
    val b0: Double,
    /** Схема соединения обмоток. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val connectionKind: WindingConnection,
    /** Активная проводимость прямой последовательности шунта намагничивания, приведенная к номинальному напряжению вывода с наивысшим напряжением, См */
    val g: Double,
    /** Активная проводимость нулевой последовательности шунта намагничивания, приведенная к номинальному напряжению вывода с наивысшим напряжением, См */
    val g0: Double,
    /** Группа соединения обмоток */
    val phaseAngleClock: Int,
    /** Активное сопротивление прямой последовательности, Ом */
    val r: Double,
    /** Активное сопротивление нулевой последовательности, Ом */
    val r0: Double,
    /** Номинальная полная мощность, МВА */
    val ratedS: Double,
    /** Номинальное напряжение вывода трансформатора, кВ */
    val ratedU: Double,
    /** Реактивное сопротивление прямой последовательности, Ом */
    val x: Double,
    /** Реактивное сопротивление нулевой последовательности, Ом */
    val x0: Double,
    /** Технические параметры вывода трансформатора */
    val rf_TransformerEndInfo: TransformerEndInfo?,
    override val baseVoltage: BaseVoltage?,
    override val phaseTapChanger: PhaseTapChanger?,
    override val ratioTapChanger: RatioTapChanger?,
    override val terminal: Terminal?,
    override val endNumber: Int,
    override val grounded: Boolean,
    override val rground: Double,
    override val xground: Double,
    override val coreAdmittance: TransformerCoreAdmittance?,
    override val fromMeshImpedance: Array<TransformerMeshImpedance>,
    override val toMeshImpedance: Array<TransformerMeshImpedance>,
    override val starImpedance: TransformerStarImpedance?,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : TransformerEnd

/** Регулятор коэффициента трансформации */
class RatioTapChanger(
    /** Вывод силового трансформатора, к которому относится переключатель регулировочных ответвлений с продольным регулированием */
    val transformerEnd: TransformerEnd,
    /** Процент изменения напряжения при изменении регулировочного ответвления, % */
    val stepVoltageIncrement: Double,
    /** Таблично заданная зависимость коэффициента трансформации и изменений проводимостей и сопротивлений от номера регулировочного ответвления */
    val ratioTapChangerTable: RatioTapChangerTable?,
    /** Таблично заданная зависимость эксплуатационного ограничения/предела от положения переключателя регулировочных ответвлений */
    val rf_TapChangerDependentLimitTable: rf_TapChangerDependentLimitTable?,
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
) : TapChanger

/** Технические параметры асинхронной машины */
class rf_AsynchronousMachineInfo(
    /** Максимальный момент, о.е. */
    val maxTorque: Double,
    /** Пусковой ток, о.е. */
    val startCurrent: Double,
    /** Пусковой момент, о.е. */
    val startingTorque: Double,
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

/** Событие срабатывания или пуска функции РЗА */
class rf_ProtectionOperationEvent(
    /** Функция РЗА, которая сработала/пустилась при аварийном событии */
    val protectionEquipment: ProtectionEquipment,
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

/** Объект энергоснабжения (расположение) */
class ServiceLocation(
    /** Способ доступа обслуживающего лица к объекту энергоснабжения */
    val accessMethod: String,
    /** TRUE, если требуется проверка оборудования в объекте энергоснабжения */
    val needsInspection: Boolean,
    /** Проблемы (недопуска к средствам измерений), с которыми ранее сталкивались при посещении или выполнении работ на объекте энергоснабжения */
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

/** Моментно-скоростная характеристика */
class rf_TorqueSpeedCurve(
    /** Асинхронная машина, к которой относится моментно-скоростная характеристика */
    val rf_AsynchronousMachine: Array<AsynchronousMachine>,
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

/** Экземпляр НТИ, за исключением файлов осциллограмм и файлов ОМП */
class rf_ProtectionEquipmentDocument(
    /** Набор параметров НТИ, представляющий тип данного файла НТИ */
    val pEData: rf_ProtectionEquipmentData,
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