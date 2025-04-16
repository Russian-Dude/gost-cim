import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Стиль отрисовки схемы */
class DiagramStyle(
    /** Схемы, которые отображены в соответствии с определенным стилем */
    val diagram: Array<Diagram>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Строка таблицы зависимости параметров обмотки трансформатора от положения регулировочного ответвления */
open class TapChangerTablePoint(
    /** Отклонение реактивной проводимости намагничивания от номинального значения, % */
    val b: Double,
    /** Отклонение активной проводимости намагничивания от номинального значения, % */
    val g: Double,
    /** Отклонение продольного активного сопротивления обмотки от номинального значения, % */
    val r: Double,
    /** Отношение напряжения для заданного положения регулировочного ответвления к номинальному, о.е. */
    val ratio: Double,
    /** Положение регулировочного ответвления */
    val step: Int,
    /** Отклонение продольного реактивного сопротивления обмотки от номинального значения, % */
    val x: Double
)

/** Система географических координат */
class CoordinateSystem(
    /** Расположения объекта энергосистемы в данной системе координат */
    val locations: Array<Location>,
    /** Тип координатной системы в форме унифицированного имени ресурса - URN */
    val crsUrn: String,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Даты этапов ввода в эксплуатацию */
class InUseDate(
    /** Дата ввода в эксплуатацию */
    val inUseDate: LocalDateTime,
    /** Дата перехода в состояние "Не готово к эксплуатации" */
    val notReadyForUseDate: LocalDateTime,
    /** Дата готовности для ввода в эксплуатацию */
    val readyForUseDate: LocalDateTime
)

/** Псевдоним значения. Описывает смысл одного из возможных значений дискретного параметра */
class ValueToAlias(
    /** Значение дискретного измерения, для которого определен физический смысл названием данного псевдонима значения */
    val value: Int,
    /** Набор псевдонимов значений, в который включен данный псевдоним значения */
    val valueAliasSet: ValueAliasSet,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Указывает конечному устройству (или группе конечных устройств) выполнить указанное действие */
class EndDeviceControl(
    /** Причина управляющего воздействия, позволяющего определить, как продолжать обработку */
    val reason: String,
    /** Тип управления элементом управления конечным устройством */
    val endDeviceControlType: EndDeviceControlType?,
    /** Конечные устройства, получающие команды от элемента управления конечным устройством */
    val endDevices: Array<EndDevice>,
    /** Точки поставки, получающие команды от элемента управления конечным устройством */
    val usagePoints: Array<UsagePoint>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Типы НТИ, за исключением осциллограмм и файлов ОМП */
class rf_NTDKind(
    /** Тип не указан */
    val none: Any,
    /** Файл параметрирования */
    val configurationData: Any,
    /** Отчет об аварийном событии */
    val incidentReport: Any,
    /** Журнал срабатывания */
    val tripLog: Any
)

/** Строка таблицы зависимости коэффициента трансформации и изменений проводимостей и сопротивлений в зависимости от номера регулировочного ответвления */
class RatioTapChangerTablePoint(
    /** Таблица переключателя регулировочных ответвлений обмотки трансформатора с продольным регулированием, к которой относится указанная строка таблицы */
    val ratioTapChangerTable: RatioTapChangerTable,
    b: Double,
    g: Double,
    r: Double,
    ratio: Double,
    step: Int,
    x: Double
) : TapChangerTablePoint(
    b = b,
    g = g,
    r = r,
    ratio = ratio,
    step = step,
    x = x
)

/** Общие технические параметры проводников различных видов */
open class WireInfo(
    /** Если присвоено значение "Истина", проводник изолирован */
    val insulated: Boolean,
    /** Изоляционный материал. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val insulationMaterial: WireInsulationKind,
    /** Материал проводника. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val material: WireMaterialKind,
    /** Номинальный ток, А */
    val ratedCurrent: Double,
    /** Радиус (центрального) сердечника провода, м (если материалы отличаются) */
    val coreRadius: Double,
    /** Сечение проводника, м2 */
    val rf_crossSection: Double,
    /** Толщина изоляции проводника, м */
    val insulationThickness: Double,
    /** Внешний радиус проводника, м */
    val radius: Double,
    /** Удельное сопротивление постоянному току при температуре 20 °C, Ом/м */
    val rDC20: Double,
    /** Текстовая маркировка проводника или его сечения */
    val sizeDescription: String,
    /** Фазы участка линии переменного тока, к которым относится информация о проводнике */
    val wirePhaseInfo: Array<WirePhaseInfo>,
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

/** Технические параметры бесщеточного возбудителя */
class rf_BrushlessExciterInfo(
    /** Кратность расфорсировки по напряжению возбуждения возбудителя, о.е. */
    val deexcitationRatio: Double,
    /** Кратность форсировки по напряжению возбуждения возбудителя, о.е. */
    val forcingRatio: Double,
    /** Номинальная активная мощность возбудителя, МВт */
    val nominalP: Double,
    /** Номинальный ток, А */
    val ratedCurrent: Double,
    /** Номинальное напряжение, кВ */
    val ratedVoltage: Double,
    /** Активное сопротивление обмотки возбуждения, Ом */
    val rExcitationWinding: Double,
    /** Активное сопротивление ротора генератора, Ом */
    val rotorResistance: Double,
    /** Сопротивление дополнительного резистора в обмотке возбуждения бесщеточного возбудителя, Ом */
    val rAdditionalResistor: Double,
    /** Реактивное сопротивление рассеяния (ненасыщенное), о.е. */
    val xs: Double,
    /** Постоянная времени обмотки возбуждения возбудителя при разомкнутой обмотке якоря возбудителя, с */
    val td: Double,
    /** Сверхпереходное реактивное сопротивление по продольной оси  (ненасыщенное), о.е. */
    val xDirectSubtrans: Double,
    /** Синхронное реактивное сопротивление по продольной оси XdB, о.е. */
    val xDirectSync: Double,
    /** Переходное реактивное сопротивление по продольной оси , о.е. */
    val xDirectTrans: Double,
    /** Сверхпереходное реактивное сопротивление по поперечной оси , о.е. */
    val xQuadSubtrans: Double,
    /** Синхронное реактивное сопротивление по поперечной оси XqB, о.е. */
    val xQuadSync: Double,
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