import ru.vniizht.model.result.PostalAddress
import ru.vniizht.model.result.UserAttribute
import ru.vniizht.model.result.Voltage
import java.time.LocalDateTime
import java.util.*

/** Расположение материальных объектов и энергообъектов */
open class Location(
    /** Электронный адрес. Структурный класс */
    val electronicAddress: ElectronicAddress,
    /** Основной адрес. Структурный класс */
    val mainAddress: StreetAddress,
    /** Номер телефона. Структурный класс */
    val phone1: TelephoneNumber,
    /** Дополнительный номер телефона. Структурный класс */
    val phone2: TelephoneNumber,
    /** Дополнительный адрес. Структурный класс */
    val secondaryAddress: StreetAddress,
    /** Материальные объекты в данном расположении */
    val assets: Array<Asset>,
    /** Система координат, используемая для описания местоположения */
    val coordinateSystem: CoordinateSystem?,
    /** Последовательность расположения координатных точек, описывающих это местоположение, выраженная в системе координат */
    val positionPoints: Array<PositionPoint>,
    /** Объекты энергосистемы в данном расположении */
    val powerSystemResources: Array<PowerSystemResource>,
    /** Направление, позволяющее полевым бригадам быстро найти данный объект */
    val direction: String,
    /** Ссылка на географический источник информации, часто не относящийся к объекту */
    val geoInfoReference: String,
    /** Статус */
    val status: Status,
    /** Классификация по корпоративным стандартам и практикам предприятия */
    val type: String,
    /** События конфигурирования местоположения */
    val configurationEvents: Array<ConfigurationEvent>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Устройство, которое указывает или записывает единицы измерения товара или другой измеряемой величины */
class Register(
    /** Если TRUE, то данные вычисляют или измеряют устройством, отличным от физического конечного устройства/прибора учета */
    val isVirtual: Boolean,
    /** Количество цифр (циферблатов на механическом приборе учета) слева от десятичного знака; по умолчанию, как правило, 5 */
    val leftDigitCount: Int,
    /** Количество цифр (циферблатов на механическом приборе учета) справа от десятичного знака */
    val rightDigitCount: Int,
    /** Интервал времени, в течение которого регистр начинает/прекращает накопление TOU (например, начало в 8:00, остановка в 17:00) */
    val touTier: TimeInterval,
    /** Имя, используемое для TOU. Например, "пиковый", "непиковый", "TOU категории А" и т.д. */
    val touTierName: String,
    /** Каналы, которые собирают/сообщают значения регистра */
    val channels: Array<Channel>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Организация */
class Organisation(
    /** Дочерние и зависимые организации, филиалы */
    val rf_ChildOrganisations: Array<Organisation>,
    /** Вышестоящая организация, филиал */
    val rf_ParentOrganisation: Organisation?,
    /** Роли, выполняемые организацией */
    val roles: Array<OrganisationRole>,
    /** Электронный адрес */
    val electronicAddress: ElectronicAddress,
    /** Номер телефона */
    val phone1: TelephoneNumber,
    /** Дополнительный номер телефона */
    val phone2: TelephoneNumber,
    /** Почтовый адрес, потенциально отличный от streetAddress (например, другой город) */
    val postalAddress: PostalAddress,
    /** Адрес улицы */
    val streetAddress: StreetAddress,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Единый путь для сбора или представления значений регистра в течение определенного периода времени */
class Channel(
    /** Если TRUE, то данные рассчитываются корпоративной системой, а не измеряются напрямую */
    val isVirtual: Boolean,
    /** Тип показания значений регистра, сообщаемых/собираемых каналом */
    val readingType: ReadingType?,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Параметры электромагнитной связи нулевой последовательности для участков линии переменного тока */
class MutualCoupling(
    /** Расстояние от первого полюса первого участка ЛЭП до начала области сближения со вторым участком ЛЭП, м */
    val distance11: Double,
    /** Расстояние от первого полюса первого участка ЛЭП до конца области сближения со вторым участком ЛЭП, м */
    val distance12: Double,
    /** Расстояние от первого полюса второго участка ЛЭП до начала области сближения с первым участком ЛЭП, м */
    val distance21: Double,
    /** Расстояние от первого полюса второго участка ЛЭП до конца области сближения с первым участком ЛЭП, м */
    val distance22: Double,
    /** Взаимная емкостная поперечная (зарядная) проводимость нулевой последовательности, См */
    val b0ch: Double,
    /** Взаимная активная поперечная (зарядная) проводимость нулевой последовательности, См */
    val g0ch: Double,
    /** Взаимное активное сопротивление нулевой последовательности, Ом */
    val r0: Double,
    /** Взаимное индуктивное сопротивление нулевой последовательности, Ом */
    val x0: Double,
    /** Полюс, относительно которого измеряется расстояние вдоль первого участка взаимосвязанной пары */
    val first_Terminal: Terminal,
    /** Полюс, относительно которого измеряется расстояние вдоль второго участка взаимосвязанной пары */
    val second_Terminal: Terminal,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** P-Q диаграмма для устройств на базе силовой электроники */
class rf_PowerElectronicsReactiveCapabilityCurve(
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

/** Значение аналогового параметра */
class AnalogValue(
    /** Значение измерения */
    val value: Double,
    /** Измеряемый аналоговый параметр */
    val analog: Analog,
    /** Управляющее воздействие, изменяющее измеряемое значение */
    val analogControl: AnalogControl?,
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

/** Тип эксплуатационного ограничения/предела */
class OperationalLimitType(
    /** Допустимая длительность нарушения эксплуатационного ограничения/предела, с */
    val acceptableDuration: Double,
    /** Направление нарушения эксплуатационного ограничения/предела. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val direction: OperationalLimitDirectionKind,
    /** Эксплуатационные ограничения/пределы данного типа */
    val operationalLimit: Array<OperationalLimit>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Технические параметры устройств продольной компенсации реактивной мощности */
open class rf_SeriesCapacitorInfo(
    /** Количество последовательно соединенных конденсаторов */
    val capacitorsInChainCount: Int,
    /** Тип последовательно соединенных конденсаторов */
    val capacitorsInChainType: String,
    /** Количество параллельных конденсаторных цепочек */
    val chainCapacitorsCount: Int,
    /** Емкость, Ф */
    val ratedCapacitance: Double,
    loss: Double,
    maxVoltage: Double,
    ratedCurrent: Double,
    ratedReactivePower: Double,
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
) : rf_SeriesCompensatorInfo(
    loss = loss,
    maxVoltage = maxVoltage,
    ratedCurrent = ratedCurrent,
    ratedReactivePower = ratedReactivePower,
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

/** Свойства ТН */
class PotentialTransformerInfo(
    /** Передаточное отношение для устройства РПН первичной обмотки */
    val primaryRatio: Ratio,
    /** Класс ТН */
    val ptClass: String,
    /** Номинальное напряжение на первичной стороне, В */
    val ratedVoltage: Voltage,
    /** Передаточное отношение для устройства РПН вторичной обмотки */
    val secondaryRatio: Ratio,
    /** Передаточное отношение для устройства РПН третичной обмотки */
    val tertiaryRatio: Ratio,
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
) : AssetInfo