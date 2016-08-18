USE [ExampleDB]

GO

CREATE TABLE [dbo].[tblNames](
        [Name] [varchar](100)  NOT NULL,
		[EmpId] [varchar](100) NOT NULL ,
	PRIMARY KEY (EmpId)
	)

	CREATE TABLE [dbo].[tblZipCode](
        [ZipCode] [varchar](100)  NOT NULL,
		[EmpId] [varchar](100) NOT NULL ,
	PRIMARY KEY (ZipCode)
	)

	CREATE TABLE [dbo].[tblTransportType](
        [ZipCode] [varchar](100)  NOT NULL,
		[VehicleType] [varchar](100) NOT NULL ,
	PRIMARY KEY (VehicleType)
	)

	

	INSERT INTO tblNames(Name,EmpId)
	       VALUES ('John','1001')
   INSERT INTO tblNames(Name,EmpId)
	       VALUES ('Mike','1002')
	INSERT INTO tblNames(Name,EmpId)
	       VALUES ('Smith','1003')

INSERT INTO tblZipCode(ZipCode,EmpId)
	       VALUES ('77001','1001')
   INSERT INTO tblZipCode(ZipCode,EmpId)
	       VALUES ('77003','1002')
	INSERT INTO tblZipCode(ZipCode,EmpId)
	       VALUES ('77005','1003')

   INSERT INTO tblTransportType(ZipCode,VehicleType)
	       VALUES ('77001','carpool')
   INSERT INTO tblTransportType(ZipCode,VehicleType)
	       VALUES ('77003','Metro')
	INSERT INTO tblTransportType(ZipCode,VehicleType)
	       VALUES ('77005','Carpool')

 GO

 select n.Name from tblNames n , tblTransportType ty, tblZipCode zc
               where n.EmpId = zc.EmpId AND zc.ZipCode = ty.Zipcode 
			         AND ty.VehicleType = 'Metro'

  Select n.Name
  FROM  tblNames n 
  INNER JOIN tblZipCode zc  ON (zc.EmpId = n.EmpId)
  INNER JOIN tblTransportType ty ON (zc.ZipCode = ty.ZipCode) 
  AND ty.VehicleType = Upper('metro')

