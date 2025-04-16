import ru.vniizht.model.result.PerCent
import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Котел */
interface SteamSupply : PowerSystemResource {
    /** Паровые турбины, снабжаемые котлом */
    val steamTurbines: Array<SteamTurbine>
}

/** Базовый класс описания конструкции ЛЭП, распределительного устройства, опор ЛЭП */
abstract class Structure(
    /** Конструктивное номинальное напряжение, на которое рассчитана конструкция участка ЛЭП, кВ */
    val ratedVoltage: Double,
    /** Удельное сопротивление грунта, Ом/м */
    val rf_rEarth: Double,
    /** Информация о расщеплении проводников ЛЭП */
    val wireSpacingInfos: Array<WireSpacingInfo>,
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

/** Аналоговый канал осциллограммы */
interface rf_AnalogChannel : rf_OscillogramChannel {
    /** Точка измерения аналогового параметра, регистрируемого в аналоговом канале осциллограммы */
    val analog: Analog
}

/** Вспомогательное оборудование */
interface AuxiliaryEquipment : Equipment {
    /** Полюс вспомогательного оборудования */
    val terminal: Terminal
}

/** Класс для моделирования эксплуатационной и технической документации, относящейся к материальному объекту (Asset), логическому устройству (PowerSystemResource). Класс Specification может содержать путь к файлу в поле electronicAddress */
abstract class Specification(
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

/** Класс для моделирования различной эксплуатационной и технической документации, относящейся к контейнеру материальных объектов, включающего в себя одну или несколько функций РЗА */
abstract class rf_PACSDeviceSpecification(
    /** Контейнер материальных объектов, содержащий одну или несколько функций РЗА и к которому относится эксплуатационная или техническая документация */
    val pACSDevice: rf_PACSDevice,
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
) : Specification(
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

/** Котел на ископаемом топливе */
interface FossilSteamSupply : SteamSupply

/** Первичный двигатель */
interface PrimeMover : PowerSystemResource {
    /** Асинхронный генератор, соединенный с первичным двигателем */
    val rf_AsynchronousMachine: AsynchronousMachine?
    /** Синхронный генератор, соединенный с первичным двигателем */
    val synchronousMachines: Array<SynchronousMachine>
    /** Номинальная активная мощность турбины, МВт */
    val rf_ratedPower: Double
    /** Номинальная частота вращения турбины, об/с */
    val rf_rotationSpeed: Double
    /** Маховой момент турбины, т·м2 */
    val rf_rotorGD2: Double
}

/** Официальное соглашение */
abstract class Agreement(
    /** Дата заключения договора [Дата и Время] */
    val signDate: LocalDateTime,
    /** Период действия договора (с момента вступления в силу до прекращения действия) [Дата и Время] */
    val validityInterval: DateTimeInterval,
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

/** Точка доступа IP, открываемая для предоставления возможности подключения с удаленных устройств */
interface IPAccessPoint : CommunicationLink {
    /** Текстовое представление адреса IP в виде десятичных цифр с точками, разрешаемое в адрес IP. Формат определяется значением атрибута addressType */
    val address: String
    /** Тип адреса IP */
    val addressType: IPAddressKind
    /** Шлюз. Текстовое представление адреса IP в виде десятичных цифр с точками первого маршрутизатора. Формат определяется значением атрибута "addressType" */
    val gateway: String
    /** Значение маски подсети IP, которое служит для разделения локальных и нелокальных адресов во время маршрутизации */
    val subnet: String
}