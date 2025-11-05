# 🧪 Test Field Officer Dashboard

## Quick Test Steps

### Step 1: Start the Server
```bash
cd backend
npm start
```

### Step 2: Create a Field Officer User
1. Go to `http://localhost:8080`
2. Click **"Sign Up"**
3. Fill in the form:
   - **Username**: testfield
   - **Password**: password123
   - **Role**: Field Officer
4. Click **"Sign Up"**

### Step 3: Login as Field Officer
1. Click **"Sign In"**
2. Enter credentials:
   - **Username**: testfield
   - **Password**: password123
3. Click **"Sign In"**
4. **You will be automatically redirected to `field-officer-dashboard.html`**

### Step 4: Explore the Dashboard

#### A) Dashboard Statistics
- You'll see 4 stat cards at the top showing counts

#### B) Farmer Registration Tab (Default)
1. Fill in farmer details:
   - Name: John Doe
   - Age: 35
   - Gender: Male
   - Phone: +256700000000
   - District: Kampala
   - Farm Size: 5
   - Crop Types: Maize, Beans
2. Click **"➕ Add Farmer"**
3. View the farmer in the table below

#### C) Farm Assignments Tab
1. Click **"Farm Assignments"** tab
2. Select the farmer you just created
3. Select a field officer (you'll need to add one first in the main dashboard)
4. Fill in:
   - Farm Location: Plot 123, Kampala
   - Farm Size: 5
   - Soil Type: Loamy
   - Priority: High
   - Crop Types: Maize, Beans
5. Click **"➕ Create Assignment"**

#### D) Field Visits Tab
1. Click **"Field Visits"** tab
2. View scheduled visits
3. Click **"Complete"** to mark visits as done

#### E) Field Reports Tab
1. Click **"Field Reports"** tab
2. Fill in report form:
   - Title: Monthly Crop Assessment
   - Report Type: Crop Assessment
   - Select Farmer and Officer
   - Description: Crops are healthy and growing well
   - Findings:
     - Soil Condition: Good moisture retention
     - Crop Health: 85% healthy plants
     - Pest Issues: None observed
     - Irrigation: Adequate
   - Statistics:
     - Area Inspected: 5
     - Crops Affected: 0
     - Estimated Yield: 2000
     - Health Score: 85
3. Select who to submit to (Manager)
4. Click **"📝 Create Report"**
5. Click **"Submit"** to send to manager

#### F) Analytics Tab
1. Click **"Analytics & Statistics"** tab
2. View three charts:
   - Visit Status Distribution
   - Soil Type Distribution
   - Visits by Officer

## ✅ Expected Behavior

- Field officers see ONLY their specialized dashboard
- They cannot access admin or manager features
- All tabs are functional with forms and tables
- Charts display real-time data
- Reports can be submitted to management

## 🐛 Troubleshooting

### Issue: "Please login first" message
**Solution**: Login through the main page first at `http://localhost:8080`

### Issue: Dropdowns are empty
**Solution**: Add farmers and field officers first

### Issue: Charts not displaying
**Solution**: Check browser console for errors. Ensure Chart.js CDN is loaded.

### Issue: Auto-redirect not working
**Solution**: Check that user role is set to `field_officer` in the database

## 🔐 User Roles

The system supports these roles:
- **admin** - Full access to all features
- **field_officer** - Access to field officer dashboard only
- **manager** - Can approve reports and manage data
- **financial_manager** - Receives financial reports

---

**Ready to Test!** 🚀
