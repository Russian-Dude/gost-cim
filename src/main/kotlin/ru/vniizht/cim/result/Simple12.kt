import ru.vniizht.model.result.Displacement
import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Субъект Российской Федерации */
class SubGeographicalRegion(
    /** Географический регион, объединяющий субъекты Российской Федерации */
    val region: GeographicalRegion?,
    /** Линии, проходящие по территории субъекта Российской Федерации */
    val lines: Array<Line>,
    /** Электростанции, находящиеся на территории субъекта Российской Федерации */
    val rf_Plants: Array<Plant>,
    /** Подстанции, находящиеся на территории субъекта Российской Федерации */
    val substations: Array<Substation>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Технические параметры статических шунтирующих компенсирующих устройств */
class rf_StaticVarCompensatorInfo(
    /** Максимальный статизм регулирования напряжения по реактивной мощности dU/dQ, кВ/Мвар */
    val maxSlope: Double,
    /** Минимальный статизм регулирования напряжения по реактивной мощности dU/dQ, кВ/Мвар */
    val minSlope: Double,
    /** Скорость изменения реактивной мощности, Мвар/с */
    val regulatingSpeed: Double,
    /** Время изменения нагрузки между границами регулировочного диапазона, с */
    val ratedRegulatingTime: Double,
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
) : ShuntCompensatorInfo(
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

/** Группа генерирующих установок с комбинированным циклом (парогазовая установка) */
class CombinedCyclePlant(
    /** Установленная мощность группы генерирующих установок с комбинированным циклом, МВт */
    val combCyclePlantRating: Double,
    /** Тепловые энергоблоки, входящие в группу генерирующих установок с комбинированным циклом */
    val thermalGeneratingUnits: Array<ThermalGeneratingUnit>,
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
) : PowerSystemResource

/** Элемент схемы, определяющий одну или несколько точек в заданном пространстве */
open class DiagramObject(
    /** Порядковый номер элемента схемы при отрисовке */
    val drawingOrder: Int,
    /** Атрибут определяет связь точек элемента схемы. Если значение "Истина", то точки объединяются в многоугольник. Если значение "Ложь", то точки объединяются в полилинию */
    val isPolygon: Boolean,
    /** Смещение по оси X.
    Смещение выражается в относительных единицах от центра элемента схемы и зависит от заданной ориентации схемы (направления горизонтальной оси):
    1) 0 указывает на отсутствие смещения от центра элемента схемы по горизонтали;
    2) -0,5 указывает на смещение от центра элемента схемы на 50% влево;
    3) 0,5 указывает на смещение от центра элемента схемы на 50% вправо */
    val offsetX: Double,
    /** Смещение по оси Y.
    Смещение выражается в относительных единицах от центра элемента схемы и зависит от заданной ориентации схемы (направления вертикальной оси):
    1) 0 указывает на отсутствие смещения от центра элемента схемы по вертикали;
    2) -0,5 указывает на смещение от центра элемента схемы на 50% вниз;
    3) 0,5 указывает на смещение от центра элемента схемы на 50% вверх */
    val offsetY: Double,
    /** Угол поворота элемента схемы в градусах по часовой стрелке относительно исходного положения:
    1) Значение угла поворота 0° обозначает:
    - точка соединения элемента, имеющего один полюс, указывает на верхнюю часть схемы;
    - точка соединения "на стороне" элемента схемы, имеющего более одного полюса, указывает на верхнюю часть схемы.
    2) Значение угла поворота 90° обозначает:
    - точка соединения элемента, имеющего один полюс, указывает на правую часть схемы;
    - точка соединения "на стороне" элемента схемы, имеющего более одного полюса, указывает на правую часть схемы */
    val rotation: Double,
    /** Объект информационной модели, с которым связан элемент схемы */
    val identifiedObject: IdentifiedObject?,
    /** Схема, на которой отображен элемент */
    val diagram: Diagram,
    /** Слои схемы, на которых отображен элемент схемы */
    val visibilityLayers: Array<VisibilityLayer>,
    /** Совокупность точек элемента схемы */
    val diagramObjectPoints: Array<DiagramObjectPoint>,
    /** Стиль, в соответствии с которым отображен элемент схемы */
    val diagramObjectStyle: DiagramObjectStyle?,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Пространственное расположение фазного проводника */
class WirePosition(
    /** Горизонтальная координата проводника относительно общей оси, м */
    val xCoord: Displacement,
    /** Вертикальная координата проводника относительно земли, м */
    val yCoord: Displacement,
    /** Информация о фазе проводника */
    val wirePhaseInfo: Array<WirePhaseInfo>,
    /** Параметры расщепления провода */
    val wireSpacingInfo: WireSpacingInfo?,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Стиль отрисовки элемента схемы */
class DiagramObjectStyle(
    /** Элементы схемы, которые отображены в соответствии с определенным стилем */
    val styledObjects: Array<DiagramObject>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Технические параметры секции шин */
class BusbarSectionInfo(
    /** Номинальный ток секции шин, А */
    val ratedCurrent: Double,
    /** Номинальное напряжение секции шин, кВ */
    val ratedVoltage: Double,
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

/** Фаза участка ЛЭП */
class ACLineSegmentPhase(
    /** Буквенное обозначение фазы. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val phase: SinglePhaseKind,
    /** Порядковый номер фазы, совпадающий с нумерацией фаз в классах WirePosition, WirePhaseInfo */
    val sequenceNumber: Int,
    /** Участок линии переменного тока для отдельной ее фазы */
    val aCLineSegment: ACLineSegment?,
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
) : PowerSystemResource

/** Спецификация требований к измерению для конкретной точки в сети */
class MetrologyRequirement(
    /** Причина метрологического требования */
    val reason: ReadingReasonKind,
    /** Типы показаний, которые должны быть собраны в соответствии с метрологическим требованием */
    val readingTypes: Array<ReadingType>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Сопротивления трансформатора по модели звезда. Применяются для 2- и 3-обмоточных трансформаторов */
class TransformerStarImpedance(
    /** Активное сопротивление прямой последовательности, Ом */
    val r: Double,
    /** Активное сопротивление нулевой последовательности, Ом */
    val r0: Double,
    /** Реактивное сопротивление прямой последовательности, Ом */
    val x: Double,
    /** Реактивное сопротивление нулевой последовательности, Ом */
    val x0: Double,
    /** Выводы трансформатора, с которыми связаны электрические параметры трансформатора по модели звезда */
    val transformerEnd: Array<TransformerEnd>,
    /** Технические параметры вывода трансформатора, с которыми связаны электрические параметры трансформатора по модели звезда */
    val transformerEndInfo: TransformerEndInfo?,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject