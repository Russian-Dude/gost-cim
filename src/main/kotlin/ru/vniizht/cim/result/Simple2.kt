import java.time.LocalDateTime
import java.util.*

/** Адрес в населенном пункте или городе */
class StreetDetail(
    /** Название строения */
    val buildingName: Any,
    /** Цифровое или символьное обозначение этажа */
    val floorIdentification: String,
    /** Название улицы */
    val name: String,
    /** Номер строения или другое обозначение расположения, связанное с улицей */
    val number: String,
    /** Номер офиса */
    val suiteNumber: String,
    /** Тип улицы (бульвар, проспект и т.п.) */
    val type: String
)

/** Рациональное число = числитель/знаменатель */
class RationalNumber(
    /** Знаменатель. Значение 1 указывает, что число является простым целым числом */
    val denominator: Int,
    /** Числитель */
    val numerator: Int
)

/** Даты внедрения */
class DeploymentDate(
    /** Дата и время ввода в работу */
    val inServiceDate: LocalDateTime,
    /** Дата и время монтажа */
    val installedDate: LocalDateTime,
    /** Дата и время перехода в состояние "Монтаж не закончен" */
    val notYetInstalledDate: LocalDateTime,
    /** Дата и время вывода из работы */
    val outOfServiceDate: LocalDateTime,
    /** Дата и время демонтажа */
    val removedDate: LocalDateTime
)

/** Тип наименования */
class NameType(
    /** Тип наименования */
    val name: String,
    /** Наименование заданного типа */
    val names: Array<Name>,
    /** Описатель типа наименования */
    val description: String
)

/** Дробь, указанная явно с числителем и знаменателем, которые можно использовать для вычисления частного */
class Ratio(
    /** Знаменатель */
    val denominator: Double,
    /** Числитель */
    val numerator: Double
)

/** Технические параметры фазы проводника */
class WirePhaseInfo(
    /** Фаза проводника. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val phaseInfo: SinglePhaseKind,
    /** Порядковый номер фазы, совпадающий с нумерацией фаз в классе ACLineSegmentPhase */
    val rf_sequenceNumber: Int,
    /** Информация о многожильном проводнике */
    val wireAssemblyInfo: WireAssemblyInfo,
    /** Информация о проводнике */
    val wireInfo: WireInfo?,
    /** Информация о расположении фазы */
    val wirePosition: WirePosition?
)

/** Тип адресов IP */
class IPAddressKind(
    /** Указывает на использование десятичной с разделителем "." нотации адреса IPv4 */
    val iPv4: Any,
    /** Указывает на использование десятичной с разделителем "." нотации адреса IPv6 */
    val iPv6: Any
)

/** Типы областей центра управления ICCP */
class ICCPScopeKind(
    /** Область виртуального центра управления, доступная любым другим сторонам обмена */
    val vCC: Any,
    /** Область центра управления, доступная для обмена только с центрами управления из двусторонней таблицы */
    val iCC: Any
)

/** Временная последовательность показаний одного и того же типа показания */
class IntervalBlock(
    /** Интервальные показания, содержащиеся в блоке */
    val intervalReadings: Array<IntervalReading>,
    /** Тип значений интервального показания, содержащихся в блоке */
    val readingType: ReadingType?
)

/** Сведения о городе в контексте адреса */
class TownDetail(
    /** Название страны */
    val country: String,
    /** Название города */
    val name: String,
    /** Район города */
    val section: String,
    /** Регион страны */
    val stateOrProvince: String,
    /** Код города */
    val code: String
)