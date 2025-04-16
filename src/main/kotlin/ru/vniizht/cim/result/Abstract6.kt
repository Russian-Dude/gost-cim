import ru.vniizht.model.result.PerCent
import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Полюс постоянного тока */
interface DCTerminal : DCBaseTerminal {
    /** Электропроводящее оборудование постоянного тока данного полюса */
    val dCConductingEquipment: DCConductingEquipment?
}

/** Генерирующая единица, накопитель или устройство, подключенные к сети переменного тока с использованием силовой электроники */
interface PowerElectronicsUnit : Equipment {
    /** "Мертвая полоса" первичного регулирования, Гц */
    val rf_deadband: Double
    /** Статизм первичного регулирования, % */
    val rf_governorSCD: Double
    /** Максимальная активная мощность преобразователя, МВт */
    val maxP: Double
    /** Минимальная активная мощность преобразователя, МВт */
    val minP: Double
    /** Устройство на базе силовой электроники для включения в сеть генерирующей единицы, накопителя или агрегата */
    val powerElectronicsConnection: PowerElectronicsConnection
}

/** Аналоговое управляющее воздействие */
interface AnalogControl : Control {
    /** Максимальное значение нормального диапазона значений для всех значений атрибута "value" */
    val maxValue: Double
    /** Минимальное значение нормального диапазона значений для всех значений атрибута "value" */
    val minValue: Double
    /** Значение измерения управляемого параметра */
    val analogValue: AnalogValue
}

/** Полюс постоянного тока преобразователя постоянного тока */
interface ACDCConverterDCTerminal : DCBaseTerminal

/** Базовый класс для динамических параметров синхронных машин */
interface SynchronousMachineDynamics : RotatingMachineDynamics {
    /** Синхронная машина, к которой относятся динамические параметры */
    val synchronousMachine: SynchronousMachine?
}

/** Электропроводящее оборудование */
interface ConductingEquipment : Equipment {
    /** Функции РЗА, защищающие первичное оборудование */
    val protectionEquipments: Array<ProtectionEquipment>
    /** Стандартное номинальное напряжение электропроводящего оборудования */
    val baseVoltage: BaseVoltage?
    /** Полюса электропроводящего оборудования */
    val terminals: Array<Terminal>
    /** Трехфазное исполнение оборудования. Смысловое назначение атрибута присутствует, если присвоено значение Истина */
    val rf_isThreePhaseEquipment: Boolean
}

/** Электропроводящее оборудование постоянного тока */
interface DCConductingEquipment : Equipment {
    /** Полюса электропроводящего оборудования постоянного тока */
    val dCTerminals: Array<DCTerminal>
}

/** Регулирующее электропроводящее оборудование */
interface RegulatingCondEq : ConductingEquipment {
    /** Система автоматического регулирования оборудования */
    val regulatingControl: RegulatingControl?
}

/** Контейнер материальных объектов, выполняющий одну или несколько функций оконечного устройства и имеющий возможность обмена данными */
abstract class EndDevice(
    /** Смещение часового пояса относительно GMT (среднее время по Гринвичу) для местоположения этого устройства в минутах */
    val timeZoneOffset: Double,
    /** Клиент, владеющий этим конечным устройством */
    val customer: Customer?,
    /** Точка поставки, к которой относится это конечное устройство */
    val usagePoint: UsagePoint?,
    /** Установочный код устройства */
    val installCode: String,
    /** Если TRUE, то сетевое устройство */
    val isPan: Boolean,
    /** Если TRUE, то физического устройства не существует. Например, виртуальный прибор учета может быть определен для агрегирования потребления для двух или более физических приборов учета. В противном случае это физическое аппаратное устройство */
    val isVirtual: Boolean,
    /** Функции конечного устройства, которые выполняет конечное устройство */
    val endDeviceFunctions: Array<EndDeviceFunction>,
    /** Данные конечного устройства */
    val endDeviceInfo: EndDeviceInfo?,
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

/** Вращающаяся машина */
interface RotatingMachine : RegulatingCondEq {
    /** (агрегирование)
    Энергоблок, к которому относится генератор */
    val generatingUnit: GeneratingUnit?
    /** Номинальный коэффициент мощности */
    val ratedPowerFactor: Double
    /** Номинальная полная мощность, МВА */
    val ratedS: Double
    /** Номинальное напряжение, кВ */
    val ratedU: Double
}