import ru.vniizht.model.result.ActivePower
import ru.vniizht.model.result.CurrentFlow
import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Интервал даты и времени */
class DateTimeInterval(
    /** Начало датированного временного интервала */
    val start: LocalDateTime,
    /** Окончание датированного временного интервала */
    val end: LocalDateTime
)

/** Публичный сертификат X509 (цифровой документ, который представляет пользователя, компьютер, службу или устройство согласно рекомендациям Сектора стандартизации электросвязи Международного союза электросвязи). Класс используется для передачи информации, которая позволяет определять используемый сертификат X509 */
class PublicX509Certificate(
    /** Имя издателя. Указывает Центр сертификации, выпустивший сертификат. Определен в соответствии с X.509 (стандартные форматы данных и процедуры распределения открытых ключей, определенные Сектором стандартизации электросвязи Международного союза электросвязи) */
    val issuerName: String,
    /** Серийный номер сертификата в соответствии с X.509 (стандартные форматы данных и процедуры распределения открытых ключей, определенные Сектором стандартизации электросвязи Международного союза электросвязи) */
    val serialNumber: String
)

/** Качество значения показания или интервального значения показания */
class ReadingQuality(
    /** Комментарий к коду качества */
    val comment: String,
    /** Система, выступающая в качестве источника кода качества */
    val source: String,
    /** Дата и время присвоения или установления кода качества [Дата и время] */
    val timeStamp: LocalDateTime,
    /** Тип качества */
    val readingQualityType: ReadingQualityType?
)

/** Таблично заданная зависимость коэффициента трансформации и изменений проводимостей и сопротивлений в зависимости от номера регулировочного ответвления */
class RatioTapChangerTable(
    /** Переключатель регулировочных ответвлений обмотки трансформатора с продольным регулированием, к которому относится таблица переключений */
    val ratioTapChanger: Array<RatioTapChanger>,
    /** Точка таблицы переключателя регулировочных ответвлений обмотки трансформатора с продольным регулированием */
    val ratioTapChangerTablePoint: Array<RatioTapChangerTablePoint>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Набор псевдонимов значений. Представляет таблицу соответствия численных значений, которые может принимать дискретный параметр, их смыслу (например, значение "0" - "Отключено", значение "1" - "Включено). Каждая строка таблицы соответствия представлена экземпляром класса ValueToAlias */
class ValueAliasSet(
    /** Команды управления дискретной величиной, использующие данный набор именованных значений для воздействий */
    val commands: Array<Command>,
    /** Команды дискретного управления вещественной величиной, использующие данный набор именованных значений для воздействий */
    val raiseLowerCommands: Array<RaiseLowerCommand>,
    /** Псевдонимы значений в составе данного набора псевдонимов значений */
    val values: Array<ValueToAlias>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Телефонный номер */
class TelephoneNumber(
    /** Код города */
    val cityCode: String,
    /** Код страны */
    val countryCode: String,
    /** Дополнительный номер */
    val extension: String,
    /** Основная часть телефонного номера */
    val localNumber: String
)

/** Возможности, присущие конечному устройству (т.е. функции, которые оно поддерживает) */
class EndDeviceCapability(
    /** TRUE, если поддерживается автономная функция DST (летнее время) */
    val autonomousDst: Boolean,
    /** TRUE, если поддерживается функция связи */
    val communication: Boolean,
    /** TRUE, если поддерживается функция подключения и отключения */
    val connectDisconnect: Boolean,
    /** TRUE, если поддерживается функция сброса */
    val demandResponse: Boolean,
    /** TRUE, если поддерживается функция учета электрической энергии */
    val electricMetering: Boolean,
    /** TRUE, если поддерживается функция учета газа */
    val gasMetering: Boolean,
    /** TRUE, если поддерживается функция метрологии */
    val metrology: Boolean,
    /** TRUE, если по запросу поддерживается функция чтения */
    val onRequestRead: Boolean,
    /** TRUE, если поддерживается функция истории отключений */
    val outageHistory: Boolean,
    /** TRUE, если устройство выполняет компенсацию давления для дозированных величин */
    val pressureCompensation: Boolean,
    /** TRUE, если поддерживается информация о ценах */
    val pricingInfo: Boolean,
    /** TRUE, если устройство выдает импульсные выходы */
    val pulseOutput: Boolean,
    /** TRUE, если поддерживается функция программирования реле */
    val relaysProgramming: Boolean,
    /** TRUE, если поддерживается функция обратного направления */
    val reverseFlow: Boolean,
    /** TRUE, если устройство выполняет суперкомпенсацию сжимаемости для измеренных величин */
    val superCompressibilityCompensation: Boolean,
    /** TRUE, если устройство выполняет температурную компенсацию измеренных величин */
    val temperatureCompensation: Boolean,
    /** TRUE, если поддерживается отображение текстовых сообщений */
    val textMessage: Boolean,
    /** TRUE, если поддерживается функция учета воды */
    val waterMetering: Boolean
)

/** Физически контролирует доступ к AssetContainers */
class Seal(
    /** Дата и время нанесения пломбы [Дата и время] */
    val appliedDateTime: LocalDateTime,
    /** Состояние пломбы */
    val condition: SealConditionKind,
    /** Вид пломбы */
    val kind: SealKind,
    /** Номер пломбы */
    val sealNumber: String,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Точка поставки */
class UsagePoint(
    /** Номинальное рабочее напряжение, В */
    val nominalServiceVoltage: Double,
    /** Область отключения подачи электроэнергии, в которой расположена данная точка поставки */
    val outageRegion: String,
    /** Код фазы */
    val phaseCode: PhaseCode,
    /** Приоритетное обслуживание данной точки поставки */
    val servicePriority: String,
    /** Договор с потребителем, регулирующий данную точку поставки */
    val customerAgreement: CustomerAgreement?,
    /** Оконечные устройства точки поставки */
    val endDevices: Array<EndDevice>,
    /** Оборудование, к которому относится точка учета */
    val equipments: Array<Equipment>,
    /** Расположение точки учета */
    val usagePointLocation: UsagePointLocation?,
    ///** Номинальное рабочее напряжение. Значение параметра представляется атрибутом value как число с плавающей точкой. Дополнительно могут быть указаны единицы измерения (unit) и множитель (multiplier) */
    //val nominalServiceVoltage: Voltage, // TODO ОТСУТСТВУЕТ
    /** Жизненный цикл системы считывания показаний в точке поставки в отношении готовности к выставлению счетов с помощью расширенной инфраструктуры считываний показаний */
    val amiBillingReady: AmiBillingReadyKind,
    /** TRUE, если в результате проверки или иным образом есть основания подозревать, что предыдущий биллинг мог быть выполнен с ошибочными данными. Значение следует сбросить после устранения этого потенциального несоответствия */
    val checkBilling: Boolean,
    /** Состояние точки поставки по отношению к подключению к сети */
    val connectionState: UsagePointConnectedKind,
    /** Плановый график, Вт */
    val estimatedLoad: CurrentFlow,
    /** TRUE, если заземлено */
    val grounded: Boolean,
    /** Если TRUE, то точка поставки является точкой предоставления услуг, то есть точкой поставки, где право собственности на услугу переходит из рук в руки */
    val isSdp: Boolean,
    /** Если TRUE, то точка поставки является виртуальной, то есть в сети не существует физического местоположения, где можно было бы разместить прибор учета для сбора показаний */
    val isVirtual: Boolean,
    /** Если TRUE, то минимальное или нулевое использование ожидается в точке поставки для таких ситуаций, как логическое или физическое отключение */
    val minimalUsageExpected: Boolean,
    /** Направление тока, на которое настроена точка поставки */
    val ratedCurrent: CurrentFlow,
    /** Максимальная мощность в точке поставки */
    val ratedPower: ActivePower,
    /** День цикла, как правило, в который считывается прибор учета в точке поставки */
    val readCycle: String,
    /** Идентификатор маршрута, которому назначена точка поставки для целей считывания показаний прибора учета */
    val readRoute: String,
    /** Замечания о точке поставки, например: причина, по которой ей присвоен неноминальный приоритет */
    val serviceDeliveryRemark: String,
    /** События конфигурирования точки поставки */
    val configurationEvents: Array<ConfigurationEvent>,
    /** Метрологические требования для точки поставки */
    val metrologyRequirements: Array<MetrologyRequirement>,
    /** Ценовые структуры, применимые к точке поставки (с прибором учета предоплаты, работающим как автономное устройство, без CustomerAgreement или клиента) */
    val pricingStructures: Array<PricingStructure>,
    /** Категория услуг, предоставляемая точкой поставки */
    val serviceCategory: ServiceCategory?,
    /** Объект энергоснабжения, обслуживаемый точкой поставки */
    val serviceLocation: ServiceLocation?,
    /** Коэффициенты точки поставки */
    val serviceMultipliers: Array<ServiceMultiplier>,
    /** Поставщик услуг, использующий точку поставки для предоставления услуг */
    val serviceSupplier: ServiceSupplier?,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Запись события, которое относится к материальному объекту */
open class ActivityRecord(
    /** Дата и время создания записи активности [Дата и Время] */
    val createdDateTime: LocalDateTime,
    /** Причина события, приводящего к записи активности */
    val reason: String,
    /** Уровень серьезности события, приводящего к записи активности */
    val severity: String,
    /** Информация о последствиях события, приведшего к записи активности */
    val status: Status,
    /** Тип события, приводящего к записи активности */
    val type: String,
    /** Материальные объекты, для которых была создана запись активности */
    val assets: Array<Asset>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject