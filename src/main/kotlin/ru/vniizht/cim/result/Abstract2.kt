import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Многофункциональная кривая */
interface Curve : IdentifiedObject {
    /** Тип кривой. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val curveStyle: CurveStyle
    /** Множитель по оси X. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val xMultiplier: UnitMultiplier
    /** Единица измерения по оси X. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val xUnit: UnitSymbol
    /** Множитель по оси Y1. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val y1Multiplier: UnitMultiplier
    /** Единица измерения по оси Y1. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val y1Unit: UnitSymbol
    /** Множитель по оси Y2. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val y2Multiplier: UnitMultiplier
    /** Единица измерения по оси Y2. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val y2Unit: UnitSymbol
    /** Множитель по оси Y3. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val y3Multiplier: UnitMultiplier
    /** Единица измерения по оси Y3. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val y3Unit: UnitSymbol
    /** Данные многофункциональной кривой */
    val curveDatas: Array<CurveData>
}

/** Зависимость эксплуатационных ограничений/пределов от параметров окружающей среды */
interface EnvironmentalDependentLimit : LimitDependency

/** Электрический вывод трансформатора */
interface TransformerEnd : IdentifiedObject {
    /** Стандартное номинальное напряжение вывода трансформатора */
    val baseVoltage: BaseVoltage?
    /** Фазосдвигающий переключатель регулировочных ответвлений обмотки трансформатора */
    val phaseTapChanger: PhaseTapChanger?
    /** Переключатель регулировочных ответвлений трансформатора */
    val ratioTapChanger: RatioTapChanger?
    /** Полюс силового трансформатора, к которому подключены его выводы */
    val terminal: Terminal?
    /** Номер вывода трансформатора. Вывод высшего напряжения должен иметь номер один */
    val endNumber: Int
    /** Нейтраль глухо заземлена (если присвоено значение "Истина") */
    val grounded: Boolean
    /** Активное сопротивление заземления нейтрали, Ом */
    val rground: Double
    /** Реактивное сопротивление заземления нейтрали, Ом */
    val xground: Double
    /** Электрические параметры магнитопровода трансформатора, связанные с выводом трансформатора */
    val coreAdmittance: TransformerCoreAdmittance?
    /** Все взаимные сопротивления между текущим выводом "в" и другими выводами "из" */
    val fromMeshImpedance: Array<TransformerMeshImpedance>
    /** Все взаимные сопротивления между текущим выводом "из" и другими выводами "в" */
    val toMeshImpedance: Array<TransformerMeshImpedance>
    /** Электрические параметры трансформатора по модели звезда, связанные с выводом трансформатора */
    val starImpedance: TransformerStarImpedance?
}

/** Формуляр двустороннего информационного обмена между участниками. Класс предназначен для описания информационного обмена оперативной технологической информацией, в том числе объявления передающей и принимающей сторон */
interface BilateralExchangeAgreement : IdentifiedObject {
    /** Участник, предоставляющий данные */
    val provider: BilateralExchangeActor
    /** Получатель данных */
    val consumer: BilateralExchangeActor?
}

/** Базовый класс для динамических параметров вращающихся машин */
interface DynamicsFunctionBlock : IdentifiedObject

/** Класс представляет значение измеряемой, вычисляемой либо иной величины, получаемой от определенного источника, позволяет однозначно идентифицировать источник значений измерения и технические параметры получения значений в рамках информационного обмена */
interface MeasurementValue : IdentifiedObject {
    /** Значение аналогового измерения */
    val analogValue: Any
    /** Значение дискретного измерения */
    val discreteValue: Any
    /** Время измерения. DateTime - формат представления даты и времени в нотации Zulu (см. [3]) */
    val timeStamp: LocalDateTime
}

/** Базовый класс для эксплуатационных ограничений/пределов */
interface OperationalLimit : IdentifiedObject {
    /** Модель зависимости эксплуатационного ограничения/предела */
    val limitDependencyModel: Array<LimitDependency>
    /** Пропорциональные зависимости других эксплуатационных пределов */
    val limitScalingLimit: Array<LimitScalingLimit>
    /** Набор эксплуатационных ограничений/пределов */
    val operationalLimitSet: OperationalLimitSet
    /** Тип эксплуатационного ограничения/предела */
    val operationalLimitType: OperationalLimitType?
}

/** Канал осциллограммы */
interface rf_OscillogramChannel : IdentifiedObject {
    /** Номер канала осциллографирования */
    val number: Int
    /** Наборы параметров осциллограмм, включающие данный канал */
    val oscillograms: Array<rf_Oscillogram>
    /** Функция РАС, регистрирующая данный канал осциллограммы */
    val disturbanceRecorder: rf_DisturbanceRecorder?
}

/** Обобщенный объект энергосистемы */
interface PowerSystemResource : IdentifiedObject {
    /** Материальные объекты, ассоциированные с объектом энергосистемы */
    val assets: Array<Asset>
    /** Дополнительный классификатор */
    val pSRType: PSRType?
    /** Параметры измерений, которые относятся к обобщенному объекту энергосистемы */
    val measurements: Array<Measurement>
    /** Расположение объекта энергосистемы */
    val location: Location?
    /** Информация о материальном объекте для соответствующего объекта, потомка обобщенного объекта энергосистемы */
    val assetDatasheet: AssetInfo?
    /** Управляющие воздействия, применяемые для управления данным регулирующим устройством */
    val controls: Array<Control>
}

/** Событие срабатывания, пуска или отказа РЗА */
abstract class rf_PACSOperationEvent(
    /** Вид события (срабатывание/пуск РЗА) */
    val rf_kind: rf_OperationKind,
    /** Оценка срабатывания/пуска РЗА */
    val rf_operationMark: rf_ProtectionOperationMark,
    /** Код категории персонала, используемый при осуществлении технического учета РЗА */
    val rf_personnelCode: rf_PersonnelCode,
    /** Код технической причины неправильной работы устройств РЗА и реализованных в их составе функций РЗА */
    val rf_techReasonCode: rf_TechReasonCode,
    /** Код организационной причины неправильной работы устройств РЗА и реализованных в их составе функций РЗА */
    val rf_orgReasonCode: rf_OrgReasonCode,
    /** Аварийное событие, при котором произошло срабатывание/пуск РЗА */
    val fault: Fault?,
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