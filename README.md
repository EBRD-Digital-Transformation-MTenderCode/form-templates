# Form Service
## Описание примеров запросов с платформы

Уточнение ко всем запросам: параметр **"lang"** является необязательным, если при запросе он не передан система возвращает JSON Schema в дефолтной локализации. Дефолт - **"ro" (Romanian)**.

#### 1. Form EI

##### Create:

End-points:
**create -** `/api/v1/operations?form=ei&country=...&identifierSchema=...&lang=...`

Значения параметров:

- **"form"**:  "ei" - указания типа создаваемой сущности **(required)**;
- **"country"** :  "..." - указание страны *buyer`a* **(required)**;
- **"identifierSchema"**: "..." -  указание схемы регистрации buyer`a **(required)**;
- **"lang"**:  "..." - локализация формы.

Шаблон response payload ноходится - *src/main/resources/templates/ei/create-ei-template.peb*

------------

##### Update:

End-points:
**update -** `/api/v1/operations?form=update-ei&ocid=...&lang=...`

Значения параметров:

- **"form"**:  "update-ei" - указания типа создаваемой сущности **(required)**;
- **"ocid"** :  "..." - указание ocid`a обновляемого EI **(required)**;
- **"lang"**:  "..." - локализация формы.

Шаблон response payload ноходится - *src/main/resources/templates/ei/update-ei-template.peb*

------------

#### 2. Form FS

##### Create:

End-points:
**create -** `/api/v1/operations?form=fs&ocid=...&funder=...&payer=...&isEuropeanUnionFunded=...&lang=...`

Значения параметров:

- **"form"**:  "fs" - указания типа создаваемой сущности **(required)**;
- **"ocid"** :  "..." - ocid EI для которого создается FS **(required)**;
- **"funder"**: "..." -  *"buyer"*  || *"state"* || *"donor"*  **(required)**;
- **"payer"**: "..." -  *"buyer"* || *"thirdParty"* || *"funder"* **(required)**;
- **"isEuropeanUnionFunded"**: "..." - *true* || *false* **(required)**;
- **"lang"**:  "..." - локализация формы.

Уточнение по query params:

- переданный `"payer": "funder"` в запросе считается валидными данными, только в том случае, если  `"funder": "donor"`, в противном случае платформе должно вернуться сообщение с ошибкой. Все остальные комбинации валидны.

Шаблон response payload ноходится - *src/main/resources/templates/fs/create-fs-template.peb*

------------

##### Update:

End-points:
**update -** `/api/v1/operations?form=update-fs&ocid=...&lang=...`

Значения параметров:

- **"form"**:  "update-fs" - указания типа создаваемой сущности **(required)**;
- **"ocid"** :  "..." - указание ocid`a обновляемого FS **(required)**;
- **"lang"**:  "..." - локализация формы.

Шаблон response payload ноходится - *src/main/resources/templates/fs/update-fs-template.peb*

------------

#### 3. Form PN

##### Create:

End-points:
**create -** `/api/v1/operations?form=pn&ocid=...&procuringEntity=...&responsibleContactPerson=...&pmd=...&lang=..`

Значения параметров:

- **"form"**:  "pn" - указания типа создаваемой сущности **(required)**;
- **"ocid"** :  "..." - ocid EI, FS`ы которого будут использоваться** (required)**;
- **"procuringEntity"**: "..." -  *"buyer"* || *"thirdParty"* **(required)**;
- **"responsibleContactPerson"**: "..." - *"buyer"* || *"thirdParty"* **(required)**;
- **"pmd"**: "..." - *"OT"* || *"RT"* **(required)**;
- **"lang"**:  "..." - локализация формы.

Шаблон response payload ноходится - *src/main/resources/templates/pn/create-pn-template.peb*

------------

##### Update:

End-points:
**update -** `/api/v1/operations?form=update-pn&ocid=...&lang=..`

Значения параметров:

- **"form"**:  "update-pn" - указания типа создаваемой сущности **(required)**;
- **"ocid"** :  "..." - указание ocid`a обновляемого PN ** (required)**;
- **"lang"**:  "..." - локализация формы.

Шаблон response payload ноходится - *src/main/resources/templates/pn/update-pn-template.peb*

------------

#### 4. Form PIN
#### 5. Form CN

##### Create:

End-points:
**create -** `/api/v1/operations?form=cn&ocid=...&procuringEntity=...&responsibleContactPerson=...&pmd=...&lang=..`

Значения параметров:

- **"form"**:  "cn" - указания типа создаваемой сущности **(required)**;
- **"ocid"** :  "..." - ocid EI, FS`ы которого будут использоваться** (required)**;
- **"procuringEntity"**: "..." -  *"buyer"* || *"thirdParty"* **(required)**;
- **"responsibleContactPerson"**: "..." - *"buyer"* || *"thirdParty"* **(required)**;
- **"pmd"**: "..." - *"OT"* || *"RT"* **(required)**;
- **"lang"**:  "..." - локализация формы.

Шаблон response payload ноходится - *src/main/resources/templates/cn/create-cn-template.peb*

------------

##### Update:

End-points:
**update -** `/api/v1/operations?form=update-cn&ocid=...&lang=..`

Значения параметров:

- **"form"**:  "update-cn" - указания типа создаваемой сущности **(required)**;
- **"ocid"** :  "..." - указание ocid`a обновляемого CN ** (required)**;
- **"lang"**:  "..." - локализация формы.

Шаблон response payload ноходится - *src/main/resources/templates/cn/update-cn-template.peb*

------------

#### 6. Form Bid

##### Create:

End-points:
**create -** `/api/v1/operations?form=bid&ocid=...&lot-id=...&lang=...`

Значения параметров:

- **"form"**:  "bid" - указания типа создаваемой сущности **(required)**;
- **"ocid"** :  "..." - ocid стадии тендерного процесса в которой подается bid **(required)**;
- **"lot-id"**: "..." -  id лота на который подается bid **(required)**;
- **"lang"**:  "..." - локализация формы.

Шаблон response payload ноходится - *src/main/resources/templates/bid/create-bid-template.peb*

------------

##### Update:

End-points:
**update -** `/api/v1/operations?form=update-bid&ocid=...&lot-id=...&lang=...`

Значения параметров:

- **"form"**:  "update-bid" - указания типа создаваемой сущности **(required)**;
- **"ocid"** :  "..." - ocid стадии тендерного процесса в которой подается bid **(required)**;
- **"lot-id"**: "..." -  id лота на который подается bid **(required)**;
- **"lang"**:  "..." - локализация формы.

Шаблон response payload ноходится - *src/main/resources/templates/bid/update-bid-template.peb*

------------

#### 7. Form Enquiry

End-points:
**create  ** `/api/v1/operations?form=enquiry&lot-id=...&lang=...`

Значения параметров:

- **"form"**:  "enquiry" - указания типа создаваемой сущности **(required)**;
- **"lot-id"** :  "..." - id лота на который подается enquiry **(required)**;
- **"lang"**:  "..." - локализация формы.

Шаблон response payload ноходится - *src/main/resources/templates/enquiry/create-enquiry-template.peb*

------------

#### 8. Form Answer

End-points:
**create -** `/api/v1/operations?form=answer&lang=...`

Значения параметров:

- **"form"**:  "answer" - указания типа создаваемой сущности **(required)**;
- **"lang"**:  "..." - локализация формы.

Шаблон response payload ноходится - *src/main/resources/templates/answer/create-answer-template.peb*

------------

#### 9. Form Award

End-points:
**update -** `/api/v1/operations?form=update-award&lot-id=...&lang=...`

Значения параметров:

- **"form"**:  "award" - указания типа создаваемой сущности **(required)**;
- **"lot-id"**: "..." -  id лота на который подавался award **(required)**;
- **"lang"**:  "..." - локализация формы.

Шаблон response payload ноходится - *src/main/resources/templates/award/update-award-template.peb*

------------
