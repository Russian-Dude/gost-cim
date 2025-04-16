import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Федеральный округ Российской Федерации */
class GeographicalRegion(
    /** Субъекты Российской Федерации */
    val regions: Array<SubGeographicalRegion>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Идентификация владельца оборудования */
class AssetOwner(
    assets: Array<Asset>,
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
) : AssetOrganisationRole(
    assets = assets,
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

/** Аварийное событие на единице силового оборудования */
class EquipmentFault(
    occurredDateTime: LocalDateTime,
    rf_type: rf_FaultType,
    kind: PhaseConnectedFaultKind,
    phases: PhaseCode,
    faultyEquipment: Equipment?,
    outage: Outage?,
    rf_OperationEvents: Array<rf_PACSOperationEvent>,
    aliasName: String,
    description: String,
    mRID: UUID,
    name: String,
    names: Array<Name>,
    rf_OrganisationRoles: Array<OrganisationRole>,
    rf_CustomAttributes: Array<UserAttribute>,
    diagramObjects: Array<DiagramObject>
) : Fault(
    occurredDateTime = occurredDateTime,
    rf_type = rf_type,
    kind = kind,
    phases = phases,
    faultyEquipment = faultyEquipment,
    outage = outage,
    rf_OperationEvents = rf_OperationEvents,
    aliasName = aliasName,
    description = description,
    mRID = mRID,
    name = name,
    names = names,
    rf_OrganisationRoles = rf_OrganisationRoles,
    rf_CustomAttributes = rf_CustomAttributes,
    diagramObjects = diagramObjects
)

/** Группа генерирующих установок, предназначенных для выработки электроэнергии и технологического пара */
class CogenerationPlant(
    /** Установленная мощность группы генерирующих установок, предназначенных для выработки электроэнергии и технологического пара, МВт */
    val ratedP: Double,
    /** Тепловые энергоблоки, входящие в группу генерирующих установок, предназначенных для выработки электроэнергии и технологического пара */
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

/** Виртуальный центр управления ICCP. Описывает участника, предоставляющего и/или принимающего данные по протоколу ICCP */
class ICCPVirtualControlCentre(
    /** Тип безопасности приложения (см. [4]) */
    val applicationSecurityRequirement: ApplicationSecurityKind,
    /** Признак клиента и сервера. Если значение атрибута "ИСТИНА" - сущность, представленная таблицей двухстороннего обмена, способна отправлять запросы и отвечать на запросы. Если значение атрибута "ЛОЖЬ" и значение атрибута "calling", "ИСТИНА" означает, что доступна только опция ответа на запрос. Если значение атрибута "ЛОЖЬ" и значение атрибута "calling", "ЛОЖЬ" означает, что доступна только опция отправки запроса */
    val clientAndServer: Boolean,
    /** Признак подключения от источника. Используется для обозначения, может ли предоставляющая сторона устанавливать связь */
    val calling: Boolean,
    /** Минимальный интервал обновления, с */
    val minimumUpdateInterval: Int,
    /** Имя области центра управления, которую другая сторона обмена может использовать для доступа к информации в двусторонней таблице, если информация не размещена в общей (глобальной) области центра управления. Значение атрибута должно быть задано обязательно */
    val nameOfLocalICC: String,
    /** Безопасность транспортного уровня. Если значение атрибута "ИСТИНА", требуется обеспечение безопасности на транспортном уровне (см. [5]) */
    val transportSecurityRequirement: Boolean,
    /** Поддержка блока 1. Указывает на поддержку основных сервисов, если значение атрибута "ИСТИНА". Всегда должен иметь значение "ИСТИНА" (см. [6]) */
    val supportForBlock1: Boolean,
    /** Поддержка блока 2. Указывает на поддержку расширенного мониторинга условий наборов данных (Data Set), если значение атрибута - "ИСТИНА" (см. [6]) */
    val supportForBlock2: Boolean,
    /** Поддержка блока 3. Указывает на поддержку блочной передачи, если значение атрибута - "ИСТИНА" (см. [6]) */
    val supportForBlock3: Boolean,
    /** Поддержка блока 4. Указывает на поддержку информационных сообщений, если значение атрибута - "ИСТИНА" (см. [6]) */
    val supportForBlock4: Boolean,
    /** Поддержка блока 5. Указывает на поддержку управления устройствами, если значение атрибута - "ИСТИНА" (см. [6]) */
    val supportForBlock5: Boolean,
    /** Поддержка устаревшего блока 8. Указывает на поддержку учетной информации, если значение атрибута - "ИСТИНА" (см. [6]) */
    val supportForDepriciatedBlock8: Boolean,
    override val providerBilateralExchange: Array<BilateralExchangeAgreement>,
    override val consumerBilateralExchange: Array<BilateralExchangeAgreement>,
    override val communicationLink: Array<CommunicationLink>,
    override val providedBilateralIOPoint: Array<ProvidedBilateralPoint>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : BilateralExchangeActor

/** Технические параметры батареи статических конденсаторов */
class rf_ShuntCapacitorInfo(
    /** Количество последовательно соединенных конденсаторов батареи статических компенсаторов */
    val capacitorsInChainCount: Int,
    /** Тип последовательно соединенных конденсаторов батареи статических компенсаторов */
    val capacitorsInChainType: String,
    /** Количество параллельных конденсаторных цепочек батареи статических компенсаторов */
    val chainCapacitorsCount: Int,
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

/** Таблица фазосдвигающего переключателя регулировочных ответвлений обмотки трансформатора */
class PhaseTapChangerTable(
    /** Строки таблицы фазосдвигающего переключателя регулировочных ответвлений обмотки трансформатора */
    val phaseTapChangerTablePoint: Array<PhaseTapChangerTablePoint>,
    /** Фазосдвигающий переключатель регулировочных ответвлений обмотки трансформатора с табличным представлением зависимости */
    val phaseTapChangerTabular: PhaseTapChangerTabular,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** P-Q диаграмма асинхронного генератора */
class rf_AsynchronousMachineReactiveCapabilityCurve(
    /** Технические параметры асинхронной машины, к которым привязана P-Q диаграмма асинхронной машины */
    val rf_AsynchronousMachine: Array<AsynchronousMachine>,
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

/** Набор параметров типизированной информации от устройств релейной защиты и автоматики помимо осциллограмм и файлов ОМП (журналы срабатывания МП РЗА, отчеты об аварийных событиях, файлы параметрирования) */
class rf_ProtectionEquipmentData(
    /** Тип набора параметров НТИ, за исключением осциллограмм и файлов ОМП */
    val nTDKind: rf_NTDKind,
    /** МП РЗА, представленное данным материальным объектом, которое может генерировать НТИ, соответствующую набору параметров */
    val asset: Asset?,
    /** Файлы НТИ, соответствующие набору параметров */
    val pEDataInstances: Array<rf_ProtectionEquipmentDocument>,
    override val address: String,
    override val communicationLinks: Array<CommunicationLink>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : rf_NonoperativeTechnologicalData

/** Документ */
open class Document(
    /** Дата и время создания документа */
    val createdDateTime: LocalDateTime,
    /** Электронный адрес документа */
    val electronicAddress: ElectronicAddress,
    /** Дата и время последнего изменения документа */
    val lastModifiedDateTime: LocalDateTime,
    /** События конфигурирования документа */
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