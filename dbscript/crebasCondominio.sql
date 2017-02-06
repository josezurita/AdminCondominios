/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2005                    */
/* Created on:     8/12/2016 18:50:37                           */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CONDOMINIO') and o.name = 'FK_CONDOMIN_ENCARGADO_USUARIO')
alter table CONDOMINIO
   drop constraint FK_CONDOMIN_ENCARGADO_USUARIO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CUENTAS_X_COBRAR') and o.name = 'FK_CUENTAS__ADEUDA_UNIDAD_H')
alter table CUENTAS_X_COBRAR
   drop constraint FK_CUENTAS__ADEUDA_UNIDAD_H
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CUENTAS_X_PAGAR') and o.name = 'FK_CUENTAS__COBRA_PROVEEDO')
alter table CUENTAS_X_PAGAR
   drop constraint FK_CUENTAS__COBRA_PROVEEDO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CUENTAS_X_PAGAR') and o.name = 'FK_CUENTAS__GENERA_CONDOMIN')
alter table CUENTAS_X_PAGAR
   drop constraint FK_CUENTAS__GENERA_CONDOMIN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('UNIDAD_HABITACIONAL') and o.name = 'FK_UNIDAD_H_PERTENECE_TIPO_UH')
alter table UNIDAD_HABITACIONAL
   drop constraint FK_UNIDAD_H_PERTENECE_TIPO_UH
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('UNIDAD_HABITACIONAL') and o.name = 'FK_UNIDAD_H_TIENE_CONDOMIN')
alter table UNIDAD_HABITACIONAL
   drop constraint FK_UNIDAD_H_TIENE_CONDOMIN
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CONDOMINIO')
            and   name  = 'ENCARGADO_DE_FK'
            and   indid > 0
            and   indid < 255)
   drop index CONDOMINIO.ENCARGADO_DE_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CONDOMINIO')
            and   type = 'U')
   drop table CONDOMINIO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CUENTAS_X_COBRAR')
            and   name  = 'ADEUDA_FK'
            and   indid > 0
            and   indid < 255)
   drop index CUENTAS_X_COBRAR.ADEUDA_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CUENTAS_X_COBRAR')
            and   type = 'U')
   drop table CUENTAS_X_COBRAR
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CUENTAS_X_PAGAR')
            and   name  = 'COBRA_FK'
            and   indid > 0
            and   indid < 255)
   drop index CUENTAS_X_PAGAR.COBRA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CUENTAS_X_PAGAR')
            and   name  = 'GENERA_FK'
            and   indid > 0
            and   indid < 255)
   drop index CUENTAS_X_PAGAR.GENERA_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CUENTAS_X_PAGAR')
            and   type = 'U')
   drop table CUENTAS_X_PAGAR
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PROVEEDORES')
            and   type = 'U')
   drop table PROVEEDORES
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TIPO_UH')
            and   type = 'U')
   drop table TIPO_UH
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('UNIDAD_HABITACIONAL')
            and   name  = 'PERTENECE_FK'
            and   indid > 0
            and   indid < 255)
   drop index UNIDAD_HABITACIONAL.PERTENECE_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('UNIDAD_HABITACIONAL')
            and   name  = 'TIENE_FK'
            and   indid > 0
            and   indid < 255)
   drop index UNIDAD_HABITACIONAL.TIENE_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('UNIDAD_HABITACIONAL')
            and   type = 'U')
   drop table UNIDAD_HABITACIONAL
go

if exists (select 1
            from  sysobjects
           where  id = object_id('USUARIO')
            and   type = 'U')
   drop table USUARIO
go

/*==============================================================*/
/* Table: CONDOMINIO                                            */
/*==============================================================*/
create table CONDOMINIO (
   ID_CONDOMINIO        int                  not null	IDENTITY (1, 1),
   ID_USUARIO           int                  null,
   NOMBRE               varchar(50)          not null,
   DIRECCION            varchar(1024)        not null,
   DESCRIPCION          varchar(1024)        null,
   TELEFONO             varchar(15)          not null,
   LOGO                 image                not null,
   BALANCE              decimal              not null,
   constraint PK_CONDOMINIO primary key nonclustered (ID_CONDOMINIO)
)
go

/*==============================================================*/
/* Index: ENCARGADO_DE_FK                                       */
/*==============================================================*/
create index ENCARGADO_DE_FK on CONDOMINIO (
ID_USUARIO ASC
)
go

/*==============================================================*/
/* Table: CUENTAS_X_COBRAR                                      */
/*==============================================================*/
create table CUENTAS_X_COBRAR (
   ID_CC                int                  not null	IDENTITY (1, 1),
   ID_UH                int                  null,
   IDENTIFICADOR        varchar(10)          not null,
   DESCRIPCION          varchar(1024)        not null,
   MES                  int                  not null,
   ANIO                 int                  not null,
   FECHA_PAGO           varchar(1024)        null,
   VALOR                decimal              not null,
   ESTADO               bit                  not null,
   constraint PK_CUENTAS_X_COBRAR primary key nonclustered (ID_CC)
)
go

/*==============================================================*/
/* Index: ADEUDA_FK                                             */
/*==============================================================*/
create index ADEUDA_FK on CUENTAS_X_COBRAR (
ID_UH ASC
)
go

/*==============================================================*/
/* Table: CUENTAS_X_PAGAR                                       */
/*==============================================================*/
create table CUENTAS_X_PAGAR (
   ID_CP                int                  not null	IDENTITY (1, 1),
   ID_CONDOMINIO        int                  null,
   ID_PROVEEDORES       int                  null,
   IDENTIFICADOR        varchar(10)          not null,
   DESCRIPCION          varchar(1024)        not null,
   FECHA_EMISION        varchar(1024)        not null,
   FECHA_PAGO           varchar(1024)        null,
   VALOR                decimal              not null,
   ESTADO               bit                  not null,
   constraint PK_CUENTAS_X_PAGAR primary key nonclustered (ID_CP)
)
go

/*==============================================================*/
/* Index: GENERA_FK                                             */
/*==============================================================*/
create index GENERA_FK on CUENTAS_X_PAGAR (
ID_CONDOMINIO ASC
)
go

/*==============================================================*/
/* Index: COBRA_FK                                              */
/*==============================================================*/
create index COBRA_FK on CUENTAS_X_PAGAR (
ID_PROVEEDORES ASC
)
go

/*==============================================================*/
/* Table: PROVEEDORES                                           */
/*==============================================================*/
create table PROVEEDORES (
   ID_PROVEEDORES       int                  not null	IDENTITY (1, 1),
   NOMBRE               varchar(50)          not null,
   DESCRIPCION          varchar(1024)        not null,
   constraint PK_PROVEEDORES primary key nonclustered (ID_PROVEEDORES)
)
go

/*==============================================================*/
/* Table: TIPO_UH                                               */
/*==============================================================*/
create table TIPO_UH (
   ID_TIPOUH            int                  not null	IDENTITY (1, 1),
   NOMBRE_UH            varchar(15)          not null,
   DESCRIPCION          varchar(1024)        not null,
   constraint PK_TIPO_UH primary key nonclustered (ID_TIPOUH)
)
go

/*==============================================================*/
/* Table: UNIDAD_HABITACIONAL                                   */
/*==============================================================*/
create table UNIDAD_HABITACIONAL (
   ID_UH                int                  not null	IDENTITY (1, 1),
   ID_TIPOUH            int                  null,
   ID_CONDOMINIO        int                  null,
   IDENFICACION         varchar(10)          not null,
   DESCRIPCION          varchar(1024)        not null,
   ESTADO               bit                  not null,
   constraint PK_UNIDAD_HABITACIONAL primary key nonclustered (ID_UH)
)
go

/*==============================================================*/
/* Index: TIENE_FK                                              */
/*==============================================================*/
create index TIENE_FK on UNIDAD_HABITACIONAL (
ID_CONDOMINIO ASC
)
go

/*==============================================================*/
/* Index: PERTENECE_FK                                          */
/*==============================================================*/
create index PERTENECE_FK on UNIDAD_HABITACIONAL (
ID_TIPOUH ASC
)
go

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
   ID_USUARIO           int                  not null	IDENTITY (1, 1),
   NOMBRE_COMPLETO      varchar(50)          not null,
   USERNAME             varchar(50)          not null,
   CLAVE                varchar(50)          not null,
   constraint PK_USUARIO primary key nonclustered (ID_USUARIO)
)
go

alter table CONDOMINIO
   add constraint FK_CONDOMIN_ENCARGADO_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO)
go

alter table CUENTAS_X_COBRAR
   add constraint FK_CUENTAS__ADEUDA_UNIDAD_H foreign key (ID_UH)
      references UNIDAD_HABITACIONAL (ID_UH)
go

alter table CUENTAS_X_PAGAR
   add constraint FK_CUENTAS__COBRA_PROVEEDO foreign key (ID_PROVEEDORES)
      references PROVEEDORES (ID_PROVEEDORES)
go

alter table CUENTAS_X_PAGAR
   add constraint FK_CUENTAS__GENERA_CONDOMIN foreign key (ID_CONDOMINIO)
      references CONDOMINIO (ID_CONDOMINIO)
go

alter table UNIDAD_HABITACIONAL
   add constraint FK_UNIDAD_H_PERTENECE_TIPO_UH foreign key (ID_TIPOUH)
      references TIPO_UH (ID_TIPOUH)
go

alter table UNIDAD_HABITACIONAL
   add constraint FK_UNIDAD_H_TIENE_CONDOMIN foreign key (ID_CONDOMINIO)
      references CONDOMINIO (ID_CONDOMINIO)
go

