import java.time.LocalDateTime
import java.util.*

/** Режим управления катушкой Петерсена или дугогасящим реактором */
enum class PetersenCoilModeKind {
    /** Режим автоматической настройки */
    automaticPositioning,
    /** Фиксированное положение */
    fixed,
    /** Режим ручной настройки */
    manual
}

/** Элементная база устройства РЗА */
enum class rf_ElementBaseKind {
    /** Электромеханика */
    electromechanics,
    /** Микроэлектроника */
    microelectronics,
    /** Микропроцессор */
    microprocessor
}

/** Тип изоляции проводников */
enum class WireInsulationKind {
    /** Тип изоляции проводников - асбест и пропитанная лакоткань */
    asbestosAndVarnshedCambric,
    /** Тип изоляции проводников - бутил-каучук */
    butyl,
    /** Тип изоляции проводников - этилен-пропиленовый каучук */
    ethylenePropyleneRubber,
    /** Тип изоляции проводников - высокомолекулярный полиэтилен высокой плотности */
    highMolecularWeightPolyethylene,
    /** Тип изоляции проводников - трехслойный высокомолекулярный полиэтилен высокой плотности */
    treeResistantHighMolecularWeightPolyethylene,
    /** Тип изоляции проводников - промасленная бумага */
    oilPaper,
    /** Тип изоляции проводников - озоностойкая резина */
    ozoneResistantRubber,
    /** Тип изоляции проводников - обвит бумажной изоляцией */
    beltedPilc,
    /** Тип изоляции проводников - резина */
    rubber,
    /** Тип изоляции проводников - силиконовая резина */
    siliconRubber,
    /** Тип изоляции проводников - кембрик из пропитанной лакоткани */
    varnishedCambricCloth,
    /** Тип изоляции проводников - пропитанное стекловолокно */
    varnishedDacronGlass,
    /** Тип изоляции проводников - прошитый полиэтилен */
    crosslinkedPolyethylene,
    /** Тип изоляции проводников - тройной прошитый полиэтилен */
    treeRetardantCrosslinkedPolyethylene,
    /** Тип изоляции проводников - газ под высоким давлением */
    highPressureFluidFilled,
    /** Тип изоляции проводников - другой */
    other
}

/** Тип проводника кабеля */
enum class CableConstructionKind {
    /** Проводник, все слои которого скручены в одном направлении и свернуты до заданной идеальной формы, практически не имеющий промежутков между жилами */
    compacted,
    /** Проводник, подвергнутый компрессии для уменьшения пространства между его жилами */
    compressed,
    /** Проводник в сечении имеет форму, похожую на сектор круга */
    sector,
    /** Сегментированный проводник кабеля, состоящий из трех-четырех секторов, изолированных друг от друга полупроводящей изоляцией */
    segmental,
    /** Монолитный проводник кабеля */
    solid,
    /** Скрученный многожильный проводник кабеля */
    stranded,
    /** Другой вид проводника кабеля */
    other
}

/** Режимы работы, в которых асинхронная машина способна работать */
enum class AsynchronousMachineKind {
    /** Асинхронный генератор */
    generator,
    /** Асинхронный двигатель */
    motor,
    /** Асинхронная машина, способная работать в режиме генератора и двигателя */
    generatorOrMotor
}

/** Тип охлаждающего агента */
enum class CoolantType {
    /** Воздушное охлаждение */
    air,
    /** Водородное охлаждение */
    hydrogenGas,
    /** Водяное охлаждение */
    water
}

/** Коды фаз */
enum class PhaseCode {
    /** Фаза A */
    A,
    /** Фазы A и B */
    AB,
    /** Фазы A, B и C */
    ABC,
    /** Фазы A, B, C и нейтраль */
    ABCN,
    /** Фазы A, B и нейтраль */
    ABN,
    /** Фазы A и C */
    AC,
    /** Фазы A, C и нейтраль */
    ACN,
    /** Фаза A и нейтраль */
    AN,
    /** Фаза B */
    B,
    /** Фазы B и C */
    BC,
    /** Фазы B, C и нейтраль */
    BCN,
    /** Фаза B и нейтраль */
    BN,
    /** Фаза C */
    C,
    /** Фаза C и нейтраль */
    CN,
    /** Нейтраль */
    N,
    /** Неизвестная фаза, но не нейтраль */
    X,
    /** Неизвестная фаза и нейтраль */
    XN,
    /** Две неизвестные фазы */
    XY,
    /** Две неизвестные фазы и нейтраль */
    XYN,
    /** Фазы не указаны */
    none,
    /** Вторичная фаза 1 */
    s1,
    /** Вторичные фазы 1 и 2 */
    s12,
    /** Вторичные фазы 1, 2 и нейтраль */
    s12N,
    /** Вторичная фаза 1 и нейтраль */
    s1N,
    /** Вторичная фаза 2 */
    s2,
    /** Вторичная фаза 2 и нейтраль */
    s2N
}

/** Тип конструкции КЛ */
enum class UndergroundStructureKind {
    /** В земле */
    burd,
    /** Защитный короб */
    enclosure,
    /** Кабельный колодец */
    manhole,
    /** Кабельная опора */
    pad,
    /** Подземный защитный короб */
    subsurfaceEndosure,
    /** Кабельный канал */
    trench,
    /** Кабельный тоннель */
    tunnel,
    /** Подземное сооружение */
    vault,
    /** Проходной ящик (без распределительной панели) */
    pullbox
}

/** Вид пломбы */
enum class SealKind {
    /** Свинец */
    lead,
    /** Замок */
    lock,
    /** Другое */
    other,
    /** Сталь */
    steel
}

/** Вид действия функции РЗА */
enum class rf_OperationKind {
    /** Отключение от РЗА */
    trip,
    /** Пуск РЗА */
    start,
    /** РЗА сработала на сигнал */
    signal,
    /** Отказ РЗА. Термин "Отказ РЗА" следует применять при моделировании события отказа устройства РЗА */
    failure
}