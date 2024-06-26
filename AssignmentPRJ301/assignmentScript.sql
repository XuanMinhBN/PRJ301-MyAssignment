USE [master]
GO
/****** Object:  Database [PRJ301_SU23_DB]    Script Date: 14/06/2024 20:24:35 ******/
CREATE DATABASE [PRJ301_SU23_DB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PRJ301_SU23_DB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\PRJ301_SU23_DB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'PRJ301_SU23_DB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\PRJ301_SU23_DB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [PRJ301_SU23_DB] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PRJ301_SU23_DB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PRJ301_SU23_DB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET ARITHABORT OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET  ENABLE_BROKER 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET RECOVERY FULL 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET  MULTI_USER 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PRJ301_SU23_DB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [PRJ301_SU23_DB] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'PRJ301_SU23_DB', N'ON'
GO
ALTER DATABASE [PRJ301_SU23_DB] SET QUERY_STORE = OFF
GO
USE [PRJ301_SU23_DB]
GO
/****** Object:  Table [dbo].[assesment]    Script Date: 14/06/2024 20:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[assesment](
	[assesment_id] [bigint] IDENTITY(1,1) NOT NULL,
	[assesment_name] [varchar](100) NULL,
	[weight_mark] [float] NULL,
	[subject_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[assesment_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[course]    Script Date: 14/06/2024 20:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[course](
	[course_id] [bigint] IDENTITY(1,1) NOT NULL,
	[course_name] [varchar](200) NULL,
	[lecturer_id] [bigint] NULL,
	[subject_id] [bigint] NULL,
	[semester_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[course_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[exams]    Script Date: 14/06/2024 20:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[exams](
	[exam_id] [bigint] IDENTITY(1,1) NOT NULL,
	[start_time] [datetime] NULL,
	[duration] [float] NULL,
	[assesment_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[exam_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[feature]    Script Date: 14/06/2024 20:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[feature](
	[feature_id] [bigint] IDENTITY(1,1) NOT NULL,
	[url] [varchar](300) NULL,
PRIMARY KEY CLUSTERED 
(
	[feature_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[grades]    Script Date: 14/06/2024 20:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[grades](
	[exam_id] [bigint] NOT NULL,
	[student_id] [bigint] NOT NULL,
	[score] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[exam_id] ASC,
	[student_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[lecturer]    Script Date: 14/06/2024 20:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[lecturer](
	[lecturer_id] [bigint] IDENTITY(1,1) NOT NULL,
	[lecturer_name] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[lecturer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role]    Script Date: 14/06/2024 20:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role](
	[role_id] [bigint] IDENTITY(1,1) NOT NULL,
	[role_name] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role_and_feature]    Script Date: 14/06/2024 20:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role_and_feature](
	[role_id] [bigint] NOT NULL,
	[feature_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC,
	[feature_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[semester]    Script Date: 14/06/2024 20:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[semester](
	[semester_id] [bigint] IDENTITY(1,1) NOT NULL,
	[semester_year] [int] NULL,
	[season] [varchar](100) NULL,
	[active] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[semester_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[student]    Script Date: 14/06/2024 20:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[student](
	[student_id] [bigint] IDENTITY(1,1) NOT NULL,
	[roll] [varchar](8) NULL,
	[student_name] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[student_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[student_and_course]    Script Date: 14/06/2024 20:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[student_and_course](
	[student_id] [bigint] NOT NULL,
	[course_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[student_id] ASC,
	[course_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[subjects]    Script Date: 14/06/2024 20:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[subjects](
	[subject_id] [bigint] IDENTITY(1,1) NOT NULL,
	[subject_name] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[subject_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user_account]    Script Date: 14/06/2024 20:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_account](
	[user_account_id] [bigint] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](200) NULL,
	[email] [varchar](200) NULL,
	[password] [varchar](200) NULL,
	[status] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[user_account_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user_and_role]    Script Date: 14/06/2024 20:24:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_and_role](
	[user_account_id] [bigint] NOT NULL,
	[role_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[user_account_id] ASC,
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[course] ON 

INSERT [dbo].[course] ([course_id], [course_name], [lecturer_id], [subject_id], [semester_id]) VALUES (1, N'SE1859', 3, 3, 2)
SET IDENTITY_INSERT [dbo].[course] OFF
GO
SET IDENTITY_INSERT [dbo].[lecturer] ON 

INSERT [dbo].[lecturer] ([lecturer_id], [lecturer_name]) VALUES (1, N'Hoàng Xuân Sơn')
INSERT [dbo].[lecturer] ([lecturer_id], [lecturer_name]) VALUES (2, N'Ngô Tùng Sơn')
INSERT [dbo].[lecturer] ([lecturer_id], [lecturer_name]) VALUES (3, N'Phạm Quốc Khang')
INSERT [dbo].[lecturer] ([lecturer_id], [lecturer_name]) VALUES (4, N'Dương Tùng Lâm')
INSERT [dbo].[lecturer] ([lecturer_id], [lecturer_name]) VALUES (5, N'Ngô Thu Thủy')
SET IDENTITY_INSERT [dbo].[lecturer] OFF
GO
SET IDENTITY_INSERT [dbo].[role] ON 

INSERT [dbo].[role] ([role_id], [role_name]) VALUES (1, N'admin')
INSERT [dbo].[role] ([role_id], [role_name]) VALUES (2, N'instructor')
INSERT [dbo].[role] ([role_id], [role_name]) VALUES (3, N'training')
INSERT [dbo].[role] ([role_id], [role_name]) VALUES (4, N'testing')
INSERT [dbo].[role] ([role_id], [role_name]) VALUES (5, N'student')
SET IDENTITY_INSERT [dbo].[role] OFF
GO
SET IDENTITY_INSERT [dbo].[semester] ON 

INSERT [dbo].[semester] ([semester_id], [semester_year], [season], [active]) VALUES (1, 2023, N'Spring', 0)
INSERT [dbo].[semester] ([semester_id], [semester_year], [season], [active]) VALUES (2, 2023, N'Summer', 0)
INSERT [dbo].[semester] ([semester_id], [semester_year], [season], [active]) VALUES (3, 2023, N'Fall', 0)
INSERT [dbo].[semester] ([semester_id], [semester_year], [season], [active]) VALUES (4, 2024, N'Spring', 0)
INSERT [dbo].[semester] ([semester_id], [semester_year], [season], [active]) VALUES (5, 2024, N'Summer', 1)
INSERT [dbo].[semester] ([semester_id], [semester_year], [season], [active]) VALUES (6, 2024, N'Fall', 0)
INSERT [dbo].[semester] ([semester_id], [semester_year], [season], [active]) VALUES (7, 2025, N'Spring', 0)
SET IDENTITY_INSERT [dbo].[semester] OFF
GO
SET IDENTITY_INSERT [dbo].[student] ON 

INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (1, N'HE182196', N'Nguyễn Xuân Minh')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (2, N'HE180013', N'Trần Văn Thân')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (3, N'HE189014', N'Ngô Văn Thắng')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (4, N'HE182134', N'Dương Công Thịnh')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (5, N'HE181098', N'Dương Khánh Huyền')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (6, N'HE181234', N'Nguyễn Khánh Linh')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (7, N'HS189301', N'Nguyễn Bích Hồng')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (8, N'HS189311', N'Trần Anh Vũ')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (9, N'HE180921', N'Nguyễn Hồng Dinh')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (10, N'HS187801', N'Trần Xuân Trường')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (11, N'HE189012', N'Lưu Thị Kim Chi')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (12, N'HS182731', N'Đào Minh Hương')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (13, N'HS184350', N'Nguyễn Thị Kiều Chinh')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (14, N'HE182094', N'Nguyễn Như Hiển')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (15, N'HE184312', N'Nguyễn Danh Minh')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (16, N'HE180003', N'Trịnh Hoài Đức')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (17, N'HS189000', N'Nguyễn Văn Hướng')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (18, N'HE186503', N'Nguyễn Thùy Dương')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (19, N'HE187901', N'Nguyễn Thị Thùy Linh')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (20, N'HS180091', N'Nguyễn Thị Huyền')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (21, N'HE182109', N'Nguyễn Thu Huyền')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (22, N'HE182910', N'Nguyễn Anh Khôi')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (23, N'HE189013', N'Mai Quốc Toàn')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (24, N'HS180013', N'Trần Thị Thủy')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (25, N'HE184352', N'Lý Thu Hương')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (26, N'HS187861', N'Nguyễn Tiến Thành')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (27, N'HE189015', N'Phạm Tiến Mạnh')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (28, N'HE180718', N'Đỗ Viết Tú')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (29, N'HS183111', N'Dương Thiên Long')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (30, N'HE182010', N'Ngô Ngọc Thành')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (31, N'HS180980', N'Nguyễn Tiến Anh')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (32, N'HE180991', N'Nguyễn Ngọc Anh')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (33, N'HE180009', N'Nguyễn Tiến Quang')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (34, N'HS184414', N'Dương Đức Huy')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (35, N'HE181990', N'Nguyễn Thị Hồng Anh')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (36, N'HS189014', N'Nguyễn Thị Phương Thảo')
INSERT [dbo].[student] ([student_id], [roll], [student_name]) VALUES (37, N'HE189012', N'Trần Ngọc Sơn')
SET IDENTITY_INSERT [dbo].[student] OFF
GO
SET IDENTITY_INSERT [dbo].[subjects] ON 

INSERT [dbo].[subjects] ([subject_id], [subject_name]) VALUES (1, N'PRF192')
INSERT [dbo].[subjects] ([subject_id], [subject_name]) VALUES (2, N'JPD123')
INSERT [dbo].[subjects] ([subject_id], [subject_name]) VALUES (3, N'CSI104')
INSERT [dbo].[subjects] ([subject_id], [subject_name]) VALUES (4, N'IOT102')
INSERT [dbo].[subjects] ([subject_id], [subject_name]) VALUES (5, N'PRO192')
INSERT [dbo].[subjects] ([subject_id], [subject_name]) VALUES (6, N'MAS291')
INSERT [dbo].[subjects] ([subject_id], [subject_name]) VALUES (7, N'LAB211')
INSERT [dbo].[subjects] ([subject_id], [subject_name]) VALUES (8, N'DBI202')
SET IDENTITY_INSERT [dbo].[subjects] OFF
GO
SET IDENTITY_INSERT [dbo].[user_account] ON 

INSERT [dbo].[user_account] ([user_account_id], [username], [email], [password], [status]) VALUES (1, N'xumin', N'xumin@gmail.com', N'123456', 1)
INSERT [dbo].[user_account] ([user_account_id], [username], [email], [password], [status]) VALUES (2, N'sonnt', N'sonnt@fpt.edu.vn', N'123456', 1)
INSERT [dbo].[user_account] ([user_account_id], [username], [email], [password], [status]) VALUES (3, N'minhnx', N'minhnx@fpt.edu.vn', N'123456', 1)
SET IDENTITY_INSERT [dbo].[user_account] OFF
GO
INSERT [dbo].[user_and_role] ([user_account_id], [role_id]) VALUES (1, 1)
INSERT [dbo].[user_and_role] ([user_account_id], [role_id]) VALUES (2, 2)
INSERT [dbo].[user_and_role] ([user_account_id], [role_id]) VALUES (3, 5)
GO
ALTER TABLE [dbo].[assesment]  WITH CHECK ADD  CONSTRAINT [FK_assesment_subjects] FOREIGN KEY([subject_id])
REFERENCES [dbo].[subjects] ([subject_id])
GO
ALTER TABLE [dbo].[assesment] CHECK CONSTRAINT [FK_assesment_subjects]
GO
ALTER TABLE [dbo].[course]  WITH CHECK ADD  CONSTRAINT [FK_course_lecturer] FOREIGN KEY([lecturer_id])
REFERENCES [dbo].[lecturer] ([lecturer_id])
GO
ALTER TABLE [dbo].[course] CHECK CONSTRAINT [FK_course_lecturer]
GO
ALTER TABLE [dbo].[course]  WITH CHECK ADD  CONSTRAINT [FK_course_semester] FOREIGN KEY([semester_id])
REFERENCES [dbo].[semester] ([semester_id])
GO
ALTER TABLE [dbo].[course] CHECK CONSTRAINT [FK_course_semester]
GO
ALTER TABLE [dbo].[course]  WITH CHECK ADD  CONSTRAINT [FK_course_subjects] FOREIGN KEY([subject_id])
REFERENCES [dbo].[subjects] ([subject_id])
GO
ALTER TABLE [dbo].[course] CHECK CONSTRAINT [FK_course_subjects]
GO
ALTER TABLE [dbo].[exams]  WITH CHECK ADD  CONSTRAINT [FK_exams_assesment] FOREIGN KEY([assesment_id])
REFERENCES [dbo].[assesment] ([assesment_id])
GO
ALTER TABLE [dbo].[exams] CHECK CONSTRAINT [FK_exams_assesment]
GO
ALTER TABLE [dbo].[grades]  WITH CHECK ADD  CONSTRAINT [FK_grades_exams] FOREIGN KEY([exam_id])
REFERENCES [dbo].[exams] ([exam_id])
GO
ALTER TABLE [dbo].[grades] CHECK CONSTRAINT [FK_grades_exams]
GO
ALTER TABLE [dbo].[grades]  WITH CHECK ADD  CONSTRAINT [FK_grades_student] FOREIGN KEY([student_id])
REFERENCES [dbo].[student] ([student_id])
GO
ALTER TABLE [dbo].[grades] CHECK CONSTRAINT [FK_grades_student]
GO
ALTER TABLE [dbo].[role_and_feature]  WITH CHECK ADD  CONSTRAINT [FK_role_and_feature_feature] FOREIGN KEY([feature_id])
REFERENCES [dbo].[feature] ([feature_id])
GO
ALTER TABLE [dbo].[role_and_feature] CHECK CONSTRAINT [FK_role_and_feature_feature]
GO
ALTER TABLE [dbo].[role_and_feature]  WITH CHECK ADD  CONSTRAINT [FK_role_and_feature_role] FOREIGN KEY([role_id])
REFERENCES [dbo].[role] ([role_id])
GO
ALTER TABLE [dbo].[role_and_feature] CHECK CONSTRAINT [FK_role_and_feature_role]
GO
ALTER TABLE [dbo].[student_and_course]  WITH CHECK ADD  CONSTRAINT [FK_student_and_course_course] FOREIGN KEY([course_id])
REFERENCES [dbo].[course] ([course_id])
GO
ALTER TABLE [dbo].[student_and_course] CHECK CONSTRAINT [FK_student_and_course_course]
GO
ALTER TABLE [dbo].[student_and_course]  WITH CHECK ADD  CONSTRAINT [FK_student_and_course_user_account] FOREIGN KEY([student_id])
REFERENCES [dbo].[user_account] ([user_account_id])
GO
ALTER TABLE [dbo].[student_and_course] CHECK CONSTRAINT [FK_student_and_course_user_account]
GO
ALTER TABLE [dbo].[user_and_role]  WITH CHECK ADD  CONSTRAINT [FK_user_and_role_role] FOREIGN KEY([role_id])
REFERENCES [dbo].[role] ([role_id])
GO
ALTER TABLE [dbo].[user_and_role] CHECK CONSTRAINT [FK_user_and_role_role]
GO
ALTER TABLE [dbo].[user_and_role]  WITH CHECK ADD  CONSTRAINT [FK_user_and_role_user_account] FOREIGN KEY([user_account_id])
REFERENCES [dbo].[user_account] ([user_account_id])
GO
ALTER TABLE [dbo].[user_and_role] CHECK CONSTRAINT [FK_user_and_role_user_account]
GO
USE [master]
GO
ALTER DATABASE [PRJ301_SU23_DB] SET  READ_WRITE 
GO
