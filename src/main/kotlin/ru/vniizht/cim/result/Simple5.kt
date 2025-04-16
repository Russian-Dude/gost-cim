import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Событие отказа или неисправности материального объекта */
class FailureEvent(
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
) : ActivityRecord(
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

/** Параметры парового энергоблока в составе парогазовой установки при различном составе газотурбинных установок */
class rf_CapacityConfiguration(
    /** Максимальная располагаемая мощность, МВт */
    val maximumCapacity: Double,
    /** Группа генерирующих установок с комбинированным циклом (парогазовая установка) */
    val rf_CombinedCyclePlant: CombinedCyclePlant,
    /** Газотурбинные энергоблоки */
    val rf_ThermalGeneratingUnits: Array<ThermalGeneratingUnit>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Строка таблицы зависимости эксплуатационных ограничений/пределов от положения переключателя регулировочных ответвлений */
class rf_TapChangerDependentLimitPoint(
    /** Отношение значения эксплуатационного ограничения/предела для заданного положения переключателя регулировочных ответвлений к нормальному значению эксплуатационного ограничения/предела, % */
    val limitPercent: Double,
    /** Положение переключателя регулировочных ответвлений */
    val step: Int,
    /** Таблица зависимости эксплуатационных ограничений/пределов от положения переключателя регулировочных ответвлений */
    val rf_TapChangerDependentLimitTable: rf_TapChangerDependentLimitTable
)

/** Набор эксплуатационных ограничений/пределов */
class OperationalLimitSet(
    /** Полюс, к которому относится набор эксплуатационных ограничений/пределов */
    val terminal: ACDCTerminal?,
    /** Оборудование, к которому относится набор эксплуатационных ограничений/пределов */
    val equipment: Equipment?,
    /** Эксплуатационные ограничения/пределы */
    val operationalLimitValue: Array<OperationalLimit>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Соединительный узел */
class ConnectivityNode(
    /** Контейнер соединительных узлов */
    val connectivityNodeContainer: ConnectivityNodeContainer,
    /** Соединенные полюса */
    val terminals: Array<Terminal>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Технические параметры регулятора скорости турбины */
class rf_TurbineRegulatingInfo(
    /** Интервал времени, по истечении которого блокируется прием последующих команд на реализацию КРТ, КРТ+ДРТ, с */
    val fastValvingControlBlockTime: Double,
    /** Возможны импульсная (кратковременная) и длительная разгрузки под воздействием управляющего сигнала максимальной амплитуды через электрогидравлический преобразователь турбины (если присвоено значение "Истина") */
    val fastValvingControl: Boolean,
    /** Время задержки от момента подачи управляющего воздействия на электрогидравлический преобразователь до начала снижения мощности турбины, с */
    val fastValvingControlDelay: Double,
    /** Скорость снижения мощности турбины при импульсной разгрузке, МВт/с */
    val fastValvingControlRampRate: Double,
    /** Максимальная величина снижения мощности турбины при импульсной разгрузке, %. Определяют по формуле ((PН - PИРТ)/PН), где PН - номинальная активная мощность турбины, PИРТ - мощность турбины при импульсной разгрузке */
    val fastValvingControlRate: Double,
    /** Время восстановления мощности турбины после кратковременной разгрузки, с */
    val fastValvingControlRestoreTime: Double,
    /** Скорость снижения мощности турбины при ДРТ, МВт/с */
    val sustainedFastValvingControlRampRate: Double,
    /** Максимальная величина снижения мощности турбины при длительной разгрузке, %. Определяют по формуле ((PН - PДРТ)/PН), где PН - номинальная активная мощность турбины, PДРТ - мощность турбины при длительной разгрузке */
    val sustainedFastValvingControlRate: Double,
    /** Зона нечувствительности регулятора скорости, Гц */
    val freqControlDeadband: Double,
    /** Зона нечувствительности частотного корректора, Гц */
    val frequencyCorrectorDeadband: Double,
    /** Статизм частотного корректора, % */
    val frequencyCorrectorSCD: Double,
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

/** Информация о текущем состоянии, имеющая отношение к сущности */
class Status(
    /** Дата и время, для которых применяется значение статуса */
    val dateTime: LocalDateTime,
    /** Код причины или объяснение того, почему объект перешел в текущее значение состояния */
    val reason: String,
    /** Соответствующая информация, касающаяся текущего значения, в виде текста свободной формы */
    val remark: String,
    /** Значение статуса */
    val value: String
)

/** Совокупность группы точек, связанных с различными элементами схемы */
class DiagramObjectGluePoint(
    /** Две и более точки, связанные с различными элементами схемы, которые объединены в группу */
    val diagramObjectPoints: Array<DiagramObjectPoint>
)

/** Типизированное дополнительное наименование */
class Name(
    /** Типизированное дополнительное наименование объекта информационной модели */
    val name: String,
    /** Объект, имеющий типизированное наименование */
    val identifiedObject: IdentifiedObject,
    /** Тип наименования */
    val nameType: NameType
)

/** Интергармоники представляются в виде рационального числа "числитель/знаменатель", а гармоники представляются с использованием того же механизма и идентифицируются знаменателем = 1 */
class ReadingInterharmonic(
    /** Интергармонический знаменатель */
    val denominator: Int,
    /** Интергармонический числитель */
    val numerator: Int
)