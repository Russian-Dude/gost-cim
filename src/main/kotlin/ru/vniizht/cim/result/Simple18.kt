import ru.vniizht.model.result.SupplierKind
import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** ЛЭП */
class Line(
    /** Субъекты Российской Федерации, по территории которых проходит ЛЭП */
    val region: Array<SubGeographicalRegion>,
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

/** Таблица обмена ICCP. Представление формуляра двустороннего информационного обмена по протоколу ICCP между участниками */
class TASE2BilateralTable(
    /** Идентификатор двусторонней таблицы, которой обменялись стороны */
    val bilateralTableID: String,
    /** Версия протокола TASE.2, требуемого для доступа к информации в двусторонней таблице с помощью TASE.2. Для успешной организации канала обе стороны должны иметь одинаковое значение */
    val tase2version: String,
    /** Уникальное значение версии двусторонней таблицы. При любом изменении двусторонней таблицы требуется сгенерировать новое уникальное значение этого атрибута */
    val bilateralTableVersion: String,
    override val provider: BilateralExchangeActor,
    override val consumer: BilateralExchangeActor?,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : BilateralExchangeAgreement

/** Группировка компонентов ценообразования и цен, используемых при создании клиентских сборов, а также критерии приемлемости, в соответствии с которыми эти условия могут быть предложены клиенту */
class PricingStructure(
    /** Уникальный пользовательский ключ для ценовой структуры, используемый представителями компании для определения правильной ценовой структуры для распределения клиенту */
    val code: String,
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

/** Технические параметры управляемых шунтирующих реакторов */
class rf_ControlledShuntReactorInfo(
    /** Скорость изменения нагрузки с форсировкой (Только для управляемых ШР), Мвар/с */
    val boostRegulatingSpeed: Double,
    /** Максимальный статизм регулирования напряжения по реактивной мощности dU/dQ, кВ/Мвар */
    val maxSlope: Double,
    /** Минимальный статизм регулирования напряжения по реактивной мощности dU/dQ, кВ/Мвар */
    val minSlope: Double,
    /** Время изменения реактивной мощности между границами регулировочного диапазона, с */
    val ratedRegulatingTime: Double,
    /** Скорость изменения реактивной мощности, Мвар/с */
    val regulatingSpeed: Double,
    /** Напряжение короткого замыкания между сетевой обмоткой и компенсационной обмоткой, % */
    val shortCircuitVoltage: Double,
    /** Активное сопротивление прямой последовательности, Ом */
    val r: Double,
    /** Активное сопротивление нулевой последовательности, Ом */
    val r0: Double,
    /** Индуктивное сопротивление нулевой последовательности, Ом */
    val x0: Double,
    groundResistorEnergy: Double,
    neutralResistance: Double,
    neutralResistanceTime: Double,
    ratedNeutralVoltage: Double,
    ratedNeutralInsulationVoltage: Double,
    loss: Double,
    maxPowerLoss: Double,
    ratedReactivePower: Double,
    ratedCurrent: Double,
    ratedVoltage: Double,
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
) : rf_ShuntReactorInfo(
    groundResistorEnergy = groundResistorEnergy,
    neutralResistance = neutralResistance,
    neutralResistanceTime = neutralResistanceTime,
    ratedNeutralVoltage = ratedNeutralVoltage,
    ratedNeutralInsulationVoltage = ratedNeutralInsulationVoltage,
    loss = loss,
    maxPowerLoss = maxPowerLoss,
    ratedReactivePower = ratedReactivePower,
    ratedCurrent = ratedCurrent,
    ratedVoltage = ratedVoltage,
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

/** Эксплуатационное ограничение/предел по частоте */
class rf_FrequencyLimit(
    /** Нормальное значение эксплуатационного ограничения/предела по частоте, Гц */
    val normalValue: Double,
    /** Значение эксплуатационного ограничения/предела по частоте, Гц */
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

/** Роль организации - поставщик услуг по передаче электрической энергии */
class ServiceSupplier(
    /** Уникальный ссылочный префиксный номер транзакции, выдаваемый организации Международной организацией по стандартизации с целью добавления тегов к электронным финансовым транзакциям (см. [2] и [3]) */
    val issuerIdentificationNumber: String,
    /** Вид поставщика */
    val kind: SupplierKind,
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

/** Ячейка распределительного устройства. Класс, предназначенный для группировки оборудования, обычно обозначающий ячейку распределительного устройства */
class Bay(
    /** Распределительное устройство, к которому относится присоединение */
    val voltageLevel: VoltageLevel,
    /** Конфигурация соединения выключателей. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val breakerConfiguration: BreakerConfiguration,
    /** Конфигурация шин присоединения. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val busBarConfiguration: BusbarConfiguration,
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

/** Коммуникационная функция коммуникационного оборудования или устройства, такого как прибор учета */
class ComFunction(
    /** Идентификационный номер связи (например, серийный номер, IP-адрес, номер телефона и т.д.) */
    val amrAddress: String,
    /** Идентификационный номер связи (например, номер порта, серийный номер, идентификатор сборщика данных и т.д.) УСПД */
    val amrRouter: String,
    /** Вид направления коммуникации */
    val direction: ComDirectionKind,
    /** Вид технологии коммуникации */
    val technology: ComTechnologyKind,
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

/** Дискретный канал осциллограммы */
class rf_StatusChannel(
    /** Точка измерения дискретного параметра, регистрируемого в дискретном канале осциллограммы */
    val discrete: Discrete,
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
) : rf_OscillogramChannel

/** Составная часть участка ЛЭП */
class rf_ACLineSeriesSection(
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
    /** Длина сегмента участка линии переменного тока, м */
    val length: Double,
    /** Порядковый номер сегмента участка линии переменного тока */
    val sectionNumber: Int,
    /** Расстояние начала сегмента участка линии переменного тока от начала участка линии переменного тока */
    val distance: Double,
    /** Тип сегмента участка линии переменного тока */
    val type: String,
    /** Участок линии переменного тока, к которому относится сегмент */
    val rf_ACLineSegment: ACLineSegment?,
    /** Удельные параметры сегмента участка линии переменного тока */
    val rf_PerLengthImpedance: PerLengthImpedance?,
    /** Полюс участка линии переменного тока, относительно которого назначаются порядковые номера сегментов этого участка */
    val rf_Terminal: Terminal?,
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