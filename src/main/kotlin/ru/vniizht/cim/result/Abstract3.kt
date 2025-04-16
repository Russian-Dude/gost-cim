import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Канал связи. Соединение с удаленными устройствами выполняется через один или более каналов связи. Могут существовать резервные каналы связи. Класс является наследником класса "Энергообъект", что позволяет к каналам связи привязывать измерения и сигналы, которые могут использоваться для моделирования таких состояний канала, как "в работе", "выведен из эксплуатации", "отказ оборудования" и т.д. */
interface CommunicationLink : PowerSystemResource {
    /** Данные НТИ, доступные по каналу связи */
    val nonoperativeTechnologicalData: Array<rf_NonoperativeTechnologicalData>
    /** Участник обмена, использующий канал связи */
    val bilateralExchangActor: BilateralExchangeActor?
}

/** Базовый класс для обозначения ролей организаций в отношении материальных объектов */
abstract class AssetOrganisationRole(
    /** Материальные объекты с определенной организационной ролью */
    val assets: Array<Asset>,
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

/** Функция, выполняемая материальным объектом */
interface AssetFunction : IdentifiedObject {
    /** Конфигурация, указанная для функции */
    val configID: String
    /** Версия прошивки устройства */
    val firmwareID: String
    /** Аппаратная версия устройства */
    val hardwareID: String
    /** Пароль, необходимый для доступа к функции */
    val password: String
    /** Название программы */
    val programID: String
}

/** Полюс постоянного и переменного тока */
interface ACDCTerminal : IdentifiedObject {
    /** Порядковый номер полюса электропроводящего оборудования */
    val sequenceNumber: Int
    /** Параметры измерений, которые относятся к полюсу электропроводящего оборудования */
    val measurements: Array<Measurement>
    /** Эксплуатационные ограничения/пределы, относящиеся к полюсу */
    val operationalLimitSet: Array<OperationalLimitSet>
}

/** Базовый класс для результатов испытания обмоток трансформатора */
interface TransformerTest : IdentifiedObject {
    /** Базовая полная мощность, МВА */
    val basePower: Double
    /** Температура, при которой проводился опыт, °C */
    val temperature: Double
}

/** Контейнер соединительных узлов */
interface ConnectivityNodeContainer : PowerSystemResource {
    /** Соединительные узлы, входящие в контейнер соединительных узлов */
    val connectivityNodes: Array<ConnectivityNode>
}

/** Контейнер оборудования */
interface EquipmentContainer : ConnectivityNodeContainer {
    /** Единицы оборудования, относящиеся к контейнеру оборудования */
    val equipments: Array<Equipment>
    /** Единицы оборудования, имеющие дополнительную ассоциацию с контейнером оборудования. Например, выключатель и другое оборудование в ячейке могут быть ассоциированы с ЛЭП либо участок ЛЭП может быть ассоциирован с ячейками подстанций (подстанциями) */
    val additionalGroupedEquipment: Array<Equipment>
}

/** Управляющее воздействие. Используется для внешнего или автономного управления в темпе процесса. Может непосредственно задать уставку, определить импульс на увеличение/уменьшение уставки или операцию по смене коммутационного состояния выключателя */
interface Control : IOPoint {
    /** Множитель единицы измерения контролируемого параметра */
    val unitMultiplier: UnitMultiplier
    /** Единица измерения контролируемого параметра */
    val unitSymbol: UnitSymbol
    /** Регулирующее устройство, управляемое данным воздействием */
    val powerSystemResource: PowerSystemResource?
}

/** Переключатель регулировочных ответвлений трансформатора */
interface TapChanger : PowerSystemResource {
    /** Если присвоено значение "Истина", есть возможность регулирования */
    val controlEnabled: Boolean
    /** Номер максимального положения переключателя ответвлений обмоток */
    val highStep: Int
    /** Номер минимального положения переключателя ответвлений обмоток */
    val lowStep: Int
    /** Если присвоено значение "Истина", возможно переключение под нагрузкой */
    val itcFlag: Boolean
    /** Номер нейтрального положения переключателя ответвлений обмоток */
    val neutralStep: Int
    /** Количество нейтральных положений */
    val rf_neutralStepCount: Int
    /** Нормальное положение переключателя ответвлений обмоток */
    val normalStep: Int
    /** Система управления переключателя регулировочных ответвлений трансформатора */
    val tapChangerControl: TapChangerControl?
}

/** Общее представление для считанных значений */
interface BaseReading : MeasurementValue {
    /** Дата и время, когда показания были впервые переданы в измерительную систему [Дата и Время] (используются только при наличии детальных требований к аудиту) */
    val firstReportedDateTime: LocalDateTime
    /** Система, выступающая в качестве источника показания (например, клиент, автоматизированная система сбора, другая корпоративная система и т.д.) */
    val source: String
    /** Начало и конец периода для тех показаний, тип которых определен как сезонный или временной [Дата и время] */
    val timePeriod: DateTimeInterval
    /** Значение показания */
    val value: String
    /** Качества показания */
    val readingQualities: Array<ReadingQuality>
}