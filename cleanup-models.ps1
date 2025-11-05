# Remove all old models except User.js
$modelsPath = "backend\models"
$filesToRemove = @(
    "Attendance.js",
    "Class.js",
    "Course.js",
    "Enrollment.js",
    "FarmAssignment.js",
    "FarmVisit.js",
    "Farmer.js",
    "FieldOfficer.js",
    "FieldReport.js",
    "FinancialTransaction.js",
    "Result.js",
    "Student.js",
    "Teacher.js"
)

foreach ($file in $filesToRemove) {
    $filePath = Join-Path $modelsPath $file
    if (Test-Path $filePath) {
        Remove-Item $filePath -Force
        Write-Host "Removed: $file"
    }
}

Write-Host "Cleanup complete!"
